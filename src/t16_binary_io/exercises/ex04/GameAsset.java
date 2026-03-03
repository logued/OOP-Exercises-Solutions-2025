package t16_binary_io.exercises.ex04;

class GameAsset {
    private int _assetId; private String _assetName, _assetType; private int _fileSize; private byte[] _assetData;
    public GameAsset(int id, String name, String type, int size, byte[] data) {
        _assetId=id; _assetName=name.trim(); _assetType=type.trim().toLowerCase(); _fileSize=size; _assetData=data;
    }
    public int getAssetId() { return _assetId; }
    public String getAssetName() { return _assetName; }
    public String getAssetType() { return _assetType; }
    public int getFileSize() { return _fileSize; }
    public byte[] getAssetData() { return _assetData; }
}