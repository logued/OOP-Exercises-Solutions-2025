package t16_binary_io.exercises.ex05;

import tools.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

// To Download a file from the server

public class RetrieveClient {

    private static final ObjectMapper MAPPER  = new ObjectMapper();
    private static final int          PORT    = 9_207;

    // Entry point: seed the DB, download from RetrieveServer, verify byte-for-byte integrity
    public static void main(String[] args) throws Exception {
        // Retrieve row with ID=1
        int testId = 1;

        // Send a RETRIEVE_FILE request and reconstruct the file on disk
        try (Socket         socket = new Socket("localhost", PORT);
             BufferedReader in     = new BufferedReader(new InputStreamReader(socket.getInputStream(),  StandardCharsets.UTF_8));
             PrintWriter    out    = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {

            // creat a request represented as a LinkedHashMap (with key value pairs)
            Map<String, Object> request = new LinkedHashMap<>();
            request.put("type",    "RETRIEVE_FILE");
            request.put("payload", Map.of("id", testId));

            out.println(MAPPER.writeValueAsString(request));    // send request to server via socket

            String   responseJson = in.readLine();  // Wait for response from server, then process it

           ///Map<?,?> response     = MAPPER.readValue(responseJson, Map.class);
           ///Map<?,?> data         = (Map<?,?>) response.get("data");

            Map<String,Object> response     = MAPPER.readValue(responseJson, Map.class);
            Map<String,Object> data         = (Map<String,Object>) response.get("data");

            byte[] binaryData = Base64.getDecoder().decode((String) data.get("fileData"));

            Files.createDirectories(Path.of("data"));  // create a directory called "data"
            Files.write(Path.of("data/retrieved_test.bin"), binaryData);  // create/overwrite data to a file

            System.out.println("Retrieved: " + data.get("fileName") + " (" + binaryData.length + " bytes)");
        }
    }
}