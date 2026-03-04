package t16_binary_io.exercises.ex04;

import java.util.Optional;

public class Exercise {

    public static void run() throws Exception {
        String url  = "jdbc:mysql://localhost:3306/binary_data?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = "";

        JdbcGameAssetDao dao = new JdbcGameAssetDao(url, user, pass);

        byte[] buffer_large = new byte[50_000];

        int id1 = dao.insert(new GameAsset(0, "hero_sprite.png", "image/png",                  buffer_large.length, buffer_large));
        int id2 = dao.insert(new GameAsset(0, "player_map.dat",  "application/octet-stream",   buffer_large.length, buffer_large));
        int id3 = dao.insert(new GameAsset(0, "theme.ogg",       "audio/ogg",                  buffer_large.length, buffer_large));

        // Time full retrieval
        long startFull = System.nanoTime();
        Optional<GameAsset> optionalGameAsset = dao.findById(id1);
        long msFull = (System.nanoTime() - startFull) / 1_000_000;
        System.out.println("Full findById:     " + msFull + " ms");
        if(optionalGameAsset.isPresent()) {
            GameAsset gameAsset = optionalGameAsset.get();
            System.out.println(gameAsset.getAssetId() + " " + gameAsset.getAssetName());
        }
        else {
            System.out.println("No gameAsset found by dao");
        }

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




