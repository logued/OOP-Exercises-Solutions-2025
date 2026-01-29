package t08_generics_1.exercises.ex01;

final class InventoryLegacy {
    private final java.util.ArrayList _items = new java.util.ArrayList();

    public void add(Object item) {
        _items.add(item);
    }

    public Object get(int index) {
        return _items.get(index);
    }
}

final class Inventory<T> {
    private final java.util.ArrayList<T> _items = new java.util.ArrayList<>();

    public void add(T item) {
        _items.add(item);
    }

    public T get(int index) {   // SHOULD check for bounds - how?
        return _items.get(index);
    }
}

public final class Exercise {
    public static void run() {
        InventoryLegacy legacy = new InventoryLegacy();
        legacy.add("hi");
        legacy.add(123);

        String s = (String) legacy.get(0);
        System.out.println(s.toUpperCase());

        // Integer n = (Integer) legacy.get(0); // could crash at runtime (wrong cast)

        Inventory<String> safe = new Inventory<>();
        safe.add("hello");
        // safe.add(123); // does not compile

        System.out.println(safe.get(0).toUpperCase());
    }
}