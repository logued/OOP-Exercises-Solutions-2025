package t09_generics_2.exercises.ex04;

public class Fillers {

    // the sample call to this method provides an int value (Integer), so
    // T is replaced by type Integer.
    // wildcard <? super T> now means that method can accept
    // an object of type T ( i.e. an Integer)
    //

    public static <T> void fill(java.util.List<? super T> out, T value, int count) {
        if (out == null)
            throw new NullPointerException("out must not be null");

        if (count < 0)
            throw new IllegalArgumentException("count must be >= 0");

        for (int i = 0; i < count; i++)
            out.add(value);

    }
}