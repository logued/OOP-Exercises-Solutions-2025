package t09_generics_2.exercises.ex05;

public class Copier {

    // method will consume (read) elements from source "src" and
    // will produce (write) elements into a destination List "dst"

    public static <T> void copy(java.util.List<? extends T> src, java.util.List<? super T> dst) {

        if (src == null)
            throw new NullPointerException("src must not be null");

        if (dst == null)
            throw new NullPointerException("dst must not be null");

        for (T item : src)
            dst.add(item);
    }
}