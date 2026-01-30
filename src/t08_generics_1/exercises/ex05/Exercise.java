package t08_generics_1.exercises.ex05;

public final class Exercise {

    public static void run() {
        TopN<Integer> best = new TopN<>(3);
        best.add(10);
        best.add(7);
        best.add(25);
        best.add(3);
        best.add(19);

        System.out.println(best.valuesDescending()); // [25, 19, 10]
    }
}

final class TopN<T extends Comparable<T>> {
    
    private final int _capacity;
    private final java.util.ArrayList<T> _values = new java.util.ArrayList<>();

    public TopN(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("capacity must be >= 1");
        _capacity = capacity;
    }

    public void add(T item) {
        if (item == null)
            throw new NullPointerException("item must not be null");

        int insertIndex = 0;

        while (insertIndex < _values.size()) {
            T current = _values.get(insertIndex);

            // Descending: place item before the first element
            // that is smaller than it.
            if (item.compareTo(current) > 0)  // if (item > current)
                break;

            insertIndex++;
        }

        _values.add(insertIndex, item);

        while (_values.size() > _capacity)
            _values.remove(_values.size() - 1);
    }

    // a getter !
    public java.util.ArrayList<T> valuesDescending() {
        return new java.util.ArrayList<>(_values);
    }
}

