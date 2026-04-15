package t16_binary_io.exercises.ex01;

// Binary File exercise

import java.util.Arrays;

public class Exercise {

    public static void run() throws Exception {
        // Create a synthetic test file
        // i.e. generate a sequence of 256 bytes and treat it as binary content.
        // (The actual contents don't mean anything for this demo)
        byte[] synthetic = new byte[256];
        for (int i = 0; i < synthetic.length; i++)
            synthetic[i] = (byte) i;

        // Use our BinaryFileUtil class to write the binary data buffer
        // to a file as binary format.
        //
        BinaryFileUtil.writeFile("data/test_asset.bin", synthetic);

        // Round-trip test - i.e. read the file back in
        //
        byte[] original = BinaryFileUtil.readFile("data/test_asset.bin");
        BinaryFileUtil.writeFile("data/test_asset_copy.bin", original);
        byte[] copy = BinaryFileUtil.readFile("data/test_asset_copy.bin");

        System.out.println("File size: " + original.length + " bytes");
        System.out.println("Round-trip OK: " + Arrays.equals(original, copy));

        // Print first 8 bytes
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 8; i++) {
            sb.append(original[i] & 0xFF);
            if (i < 7) sb.append(", ");
        }
        sb.append("]");
        System.out.println("First 8 bytes: " + sb);
    }
}

