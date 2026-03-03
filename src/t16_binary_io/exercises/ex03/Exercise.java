package t16_binary_io.exercises.ex03;

import java.util.*;

public class Exercise {

    public static void run() throws Exception {
        String url  = "jdbc:mysql://localhost:3306/binary_data?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = "";

        GameAssetDao dao = new JdbcGameAssetDao(url, user, pass);

        byte[] original = new byte[]{10, 20, 30, 40, 50};
        GameAsset asset = new GameAsset(0, "test_sprite.bin", "application/octet-stream", original.length, original);

        int id = dao.insert(asset);
        System.out.println("Inserted asset with id=" + id);

        Optional<GameAsset> optionalGameAsset = dao.findById(id);
        if (optionalGameAsset.isPresent()) {
            GameAsset gameAsset = optionalGameAsset.get();  // extract the asset
            if(Arrays.equals(original, gameAsset.getAssetData())) {
                System.out.println("BLOB byte[] data retrieved successfully");
            }
            else {
                System.out.println("ERROR - BLOB data retrieved incorrectly");
            }
        }

//        boolean ok = found.isPresent() && Arrays.equals(original, found.get().getAssetData());
//        System.out.println("Round-trip OK: " + ok);

        System.out.println("Deleted: " + dao.deleteById(id));
    }
}




