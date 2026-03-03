package t16_binary_io.exercises.ex04;


public class Exercise {

    public static void run() throws Exception {
        String url  = "jdbc:mysql://localhost:3306/car_rental?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "car_rental_user";
        String pass = "your_password";

        JdbcGameAssetDao dao = new JdbcGameAssetDao(url, user, pass);

        byte[] large = new byte[50_000];

        int id1 = dao.insert(new GameAsset(0, "hero_sprite.png", "image/png",                  large.length, large));
        int id2 = dao.insert(new GameAsset(0, "player_map.dat",  "application/octet-stream",   large.length, large));
        int id3 = dao.insert(new GameAsset(0, "theme.ogg",       "audio/ogg",                  large.length, large));

        // Time full retrieval
        long startFull = System.nanoTime();
        dao.findById(id1);
        long msFull = (System.nanoTime() - startFull) / 1_000_000;
        System.out.println("Full findById:     " + msFull + " ms");

        // Time metadata retrieval
        long startMeta = System.nanoTime();
        dao.findMetadataById(id1);
        long msMeta = (System.nanoTime() - startMeta) / 1_000_000;
        System.out.println("Metadata only:     " + msMeta + " ms");

        for (AssetMetadata m : dao.findAllMetadata()) {
            System.out.println("[" + m.getAssetId() + "] " + m.getAssetName()
                    + " (" + m.getAssetType() + ", " + m.getFileSize() + " bytes)");
        }

        dao.deleteById(id1);
        dao.deleteById(id2);
        dao.deleteById(id3);
        System.out.println("Cleaned up 3 rows");
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