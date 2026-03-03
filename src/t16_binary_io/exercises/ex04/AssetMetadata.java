package t16_binary_io.exercises.ex04;

class AssetMetadata {

    // === Fields ===
    private int    _assetId;
    private String _assetName;
    private String _assetType;
    private int    _fileSize;

    // === Constructors ===
    // Creates: an asset metadata record — no binary data
    public AssetMetadata(int assetId, String assetName, String assetType, int fileSize) {
        _assetId   = assetId;
        _assetName = assetName;
        _assetType = assetType;
        _fileSize  = fileSize;
    }

    // === Public API ===
    public int    getAssetId()   { return _assetId; }
    public String getAssetName() { return _assetName; }
    public String getAssetType() { return _assetType; }
    public int    getFileSize()  { return _fileSize; }
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