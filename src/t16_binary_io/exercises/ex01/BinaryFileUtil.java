package t16_binary_io.exercises.ex01;

import java.nio.file.Files;
import java.nio.file.Path;

class BinaryFileUtil {

    // === Public API ===
    // Reads: a file from disk and returns its bytes
    //
    public static byte[] readFile(String strPath) throws Exception {

        if (strPath == null || strPath.isBlank())
            throw new IllegalArgumentException("path is required");

        Path path = Path.of(strPath);  // path to the file

        if (!Files.exists(path))
            throw new IllegalArgumentException("file not found: " + strPath);

        return Files.readAllBytes(path);
    }

    // Writes: a byte array (buffer) to disk file at the given path
    //
    public static void writeFile(String strPath, byte[] data) throws Exception {

        if (strPath == null || strPath.isBlank())
            throw new IllegalArgumentException("path is required");
        if (data == null)
            throw new IllegalArgumentException("data is required");

        Path path = Path.of(strPath);   // make a Path object from the path String

        if (path.getParent() != null)
            Files.createDirectories( path.getParent() ); // create the directory

        Files.write(path, data);  // creates the file and writes the data into it
    }
}