package t16_binary_io.exercises.ex02;

import java.sql.*;

public class Exercise {

    public static void run() throws Exception {
        String url  = "jdbc:mysql://localhost:3306/binary_data?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = "";

        try (Connection c = DriverManager.getConnection(url, user, pass)) {

            // Metadata-only query — asset_data deliberately excluded
            String sql = "SELECT asset_id, asset_name, asset_type, file_size FROM game_assets ORDER BY asset_id";

            try (PreparedStatement ps = c.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int    id       = rs.getInt("asset_id");
                    String name     = rs.getString("asset_name");
                    String type     = rs.getString("asset_type");
                    int    fileSize = rs.getInt("file_size");
                    System.out.println("[" + id + "] " + name + " (" + type + ", " + fileSize + " bytes)");
                }
            }

            try (PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM game_assets");
                 ResultSet rs = ps.executeQuery()) {

                rs.next();
                System.out.println("Total assets: " + rs.getInt(1));
            }
        }
    }
}