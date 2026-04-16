package t16_binary_io.exercises.ex05;

import tools.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;

// To send a file to a client that requested to download a file.

public class RetrieveServer {

    // === Constants ===
    private static final String URL     = "jdbc:mysql://localhost:3306/game_assets_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final int    PORT    = 9_207;

    // === Fields ===
    private int    _port;
    private String _url;
    private String _user;
    private String _pass;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    // === Entry point ===
    // Starts: the retrieve server; run this class before running RetrieveClient
    public static void main(String[] args) throws Exception {
        System.out.println("RetrieveServer listening on port " + PORT + " ...");
        new RetrieveServer(PORT, URL, DB_USER, DB_PASS).start();
    }

    // === Constructors ===
    // Creates: a retrieve-only server bound to the given port and database
    public RetrieveServer(int port, String url, String user, String pass) {
        _port = port;
        _url  = url;
        _user = user;
        _pass = pass;
    }

    // === Public API ===
    // Starts: the server loop; accepts connections until interrupted
    public void start() throws Exception {
        try (ServerSocket ss = new ServerSocket(_port)) {
            while (!Thread.currentThread().isInterrupted())
                handleRetrieve(ss.accept());
        }
    }

    // === Helpers ===
    // Handles: one RETRIEVE_FILE request — fetches the BLOB and Base64-encodes it for the client
    private void handleRetrieve(Socket client) {
        try (client;
             BufferedReader in  = new BufferedReader(new InputStreamReader(client.getInputStream(),  StandardCharsets.UTF_8));
             PrintWriter    out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true)) {

            String line = in.readLine();    // wait for a request from a client

            if (line == null) return;

            Map<?,?> req     = MAPPER.readValue(line, Map.class);
            Map<?,?> payload = (Map<?,?>) req.get("payload");

            int      id      = ((Number) payload.get("id")).intValue();
            System.out.println("Server received request id : " + id);

            // not that we have the requested id, we can query the database for that record

            String sql = "SELECT asset_name, asset_type, file_size, asset_data "
                            + "FROM game_assets WHERE asset_id = ?";

            try (Connection        c  = DriverManager.getConnection(_url, _user, _pass);
                 PreparedStatement ps = c.prepareStatement(sql)) {

                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {               // send a not found response to client if no match found
                        out.println(MAPPER.writeValueAsString(
                                Map.of("status", "ERROR", "message", "not found id=" + id)));
                        return;
                    }

                    // we have found a record from the database, so
                    // extract the details from the resultSet, package results into a Map,
                    // (use Base64 encoding for the binary data)
                    // convert to Json and send to client over socket
                    //
                    String name  = rs.getString("asset_name");
                    String type  = rs.getString("asset_type");
                    int    size  = rs.getInt("file_size");
                    byte[] bytes = rs.getBytes("asset_data");   // load the BLOB

                    Map<String, Object> data = new LinkedHashMap<>();
                    data.put("id",          id);
                    data.put("fileName",    name);
                    data.put("contentType", type);
                    data.put("fileSize",    size);
                    data.put("fileData",    Base64.getEncoder().encodeToString(bytes));

                    Map<String, Object> response = new LinkedHashMap<>();
                    response.put("status", "OK");
                    response.put("data",   data);
                    System.out.println("Sending response to client for id : " + id);
                    out.println(MAPPER.writeValueAsString(response));
                }
            }

        } catch (Exception e) {
            System.err.println("Retrieve handler error: " + e.getMessage());
        }
    }
}