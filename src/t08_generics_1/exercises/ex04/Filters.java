package t08_generics_1.exercises.ex04;

public final class Filters {

    /**
     *
     * @param items - List of items of some type
     * @param predicate -  a predicate  is lambda function (that returns true or false)
     *                  that is applied to each list item to filter out matching elements
     * @return - new List with filtered items
     * @param <T>
     */

    public static <T> java.util.ArrayList<T> where(
            java.util.List<T> items,
            java.util.function.Predicate<T> predicate) {

        if (predicate == null)
            throw new NullPointerException("predicate must not be null");

        java.util.ArrayList<T> out = new java.util.ArrayList<>();

        if (items == null)
            return out;

        for (T item : items) {
            if (predicate.test(item))  // apply lambda function
                out.add(item);
        }

        return out;
    }
}
