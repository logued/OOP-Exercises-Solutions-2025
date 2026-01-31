package t08_generics_1.exercises.ex08;

public final class ArraysEx {
    @SuppressWarnings("unchecked")

    // Generic method
    public static <T> T[] newArray(Class<T> elementType, int length) {

        if (elementType == null)
            throw new NullPointerException("elementType must not be null");

        if (length < 0)
            throw new IllegalArgumentException("length must be >= 0");

        // Use reflection method to create an instance of a specified type
        Object arr = java.lang.reflect.Array.newInstance(elementType, length);

        return (T[]) arr;  // cast from Object type to correct type T
    }

}
