package t16_binary_io.exercises.ex04;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Full JdbcGameAssetDao available in Exercise 03 — add these two methods to it.
class JdbcGameAssetDao {
    private String _url, _user, _pass;
    public JdbcGameAssetDao(String url, String user, String pass) { _url=url; _user=user; _pass=pass; }
    private Connection open() throws SQLException { return DriverManager.getConnection(_url,_user,_pass); }
    public int insert(GameAsset asset) throws Exception {
        String sql = "INSERT INTO game_assets (asset_name, asset_type, file_size, asset_data) VALUES (?, ?, ?, ?)";
        try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, asset.getAssetName()); ps.setString(2, asset.getAssetType());
            ps.setInt(3, asset.getFileSize()); ps.setBytes(4, asset.getAssetData());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) { keys.next(); return keys.getInt(1); }
        }
    }
    public Optional<GameAsset> findById(int id) throws Exception {
        if (id <= 0) return Optional.empty();
        String sql = "SELECT asset_id, asset_name, asset_type, file_size, asset_data FROM game_assets WHERE asset_id = ?";
        try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();
                return Optional.of(new GameAsset(rs.getInt("asset_id"), rs.getString("asset_name"),
                        rs.getString("asset_type"), rs.getInt("file_size"), rs.getBytes("asset_data")));
            }
        }
    }
    public Optional<AssetMetadata> findMetadataById(int id) throws Exception {
        if (id <= 0) return Optional.empty();
        String sql = "SELECT asset_id, asset_name, asset_type, file_size FROM game_assets WHERE asset_id = ?";
        try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();
                return Optional.of(new AssetMetadata(rs.getInt("asset_id"), rs.getString("asset_name"),
                        rs.getString("asset_type"), rs.getInt("file_size")));
            }
        }
    }
    public List<AssetMetadata> findAllMetadata() throws Exception {
        String sql = "SELECT asset_id, asset_name, asset_type, file_size FROM game_assets ORDER BY asset_id";
        try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            List<AssetMetadata> out = new ArrayList<>();
            while (rs.next())
                out.add(new AssetMetadata(rs.getInt("asset_id"), rs.getString("asset_name"),
                        rs.getString("asset_type"), rs.getInt("file_size")));
            return out;
        }
    }
    public boolean deleteById(int id) throws Exception {
        if (id <= 0) return false;
        String sql = "DELETE FROM game_assets WHERE asset_id = ?";
        try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id); return ps.executeUpdate() == 1;
        }
    }
}
// JdbcGameAssetDao — additions (findMetadataById + findAllMetadata):

// Gets: metadata only for the given ID — asset_data is not loaded
// public Optional<AssetMetadata> findMetadataById(int id) throws Exception {
//     if (id <= 0) return Optional.empty();
//     String sql = "SELECT asset_id, asset_name, asset_type, file_size FROM game_assets WHERE asset_id = ?";
//     try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql)) {
//         ps.setInt(1, id);
//         try (ResultSet rs = ps.executeQuery()) {
//             if (!rs.next()) return Optional.empty();
//             return Optional.of(new AssetMetadata(
//                 rs.getInt("asset_id"), rs.getString("asset_name"),
//                 rs.getString("asset_type"), rs.getInt("file_size")));
//         }
//     }
// }

// Gets: metadata for all assets — asset_data is not loaded
// public List<AssetMetadata> findAllMetadata() throws Exception {
//     String sql = "SELECT asset_id, asset_name, asset_type, file_size FROM game_assets ORDER BY asset_id";
//     try (Connection c = open(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
//         List<AssetMetadata> out = new ArrayList<>();
//         while (rs.next())
//             out.add(new AssetMetadata(
//                 rs.getInt("asset_id"), rs.getString("asset_name"),
//                 rs.getString("asset_type"), rs.getInt("file_size")));
//         return out;
//     }
// }