package t08_generics_1.exercises.ex03;


public final class Exercise {

    public static void run() {

        java.util.ArrayList<Integer> lengths =
                Maps.map(java.util.List.of("ant", "zebra"), String::length);
        // map() provides a List of strings and then a function (the transformer)
        // to be applied to these strings (here to get the length of each string)
        // and, returns a list of the lengths.

        java.util.ArrayList<String> labels =
                Maps.map(java.util.List.of(10, 20), n -> "HP:" + n);
        // applies the lambda to each integer to
        System.out.println(lengths); // [3, 5]
        System.out.println(labels);  // [HP:10, HP:20]
    }
}

final class Maps {

    /**
     * Map a List of Items to a corresponding transformed list of items
     * @param items - original list of items
     * @param transform - a lambda function that will transform one item to some other item
     * @return the list
     * @param <T> the type of the items in the original list
     * @param <R> the type of the items in the Result list
     */
    public static <T, R> java.util.ArrayList<R> map(
            java.util.List<T> items,
            java.util.function.Function<T, R> transform) {  // functional interface i.e. reference to a transformer function

        if (transform == null)
            throw new NullPointerException("transform must not be null");

        java.util.ArrayList<R> out = new java.util.ArrayList<>();

        if (items == null)
            return out;

        // apply the transformation (the lambda function) to
        // each item in the original list, and add each one to list
        for (T item : items)
            out.add( transform.apply(item) );

        return out;
    }
}

