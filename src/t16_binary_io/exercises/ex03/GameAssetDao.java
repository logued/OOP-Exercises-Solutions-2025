package t16_binary_io.exercises.ex03;


import java.util.Optional;

interface GameAssetDao {
    int insert(GameAsset asset) throws Exception;
    Optional<GameAsset> findById(int id) throws Exception;
    boolean deleteById(int id) throws Exception;
}