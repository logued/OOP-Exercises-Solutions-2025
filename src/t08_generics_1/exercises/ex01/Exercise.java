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

// Generic Type "Inventory"
// T is given type when Inventory is instantiated (using new)
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
        // Legacy = what was done in the past (early days of Java)
        InventoryLegacy legacy = new InventoryLegacy();
        legacy.add("hi");
        legacy.add(123);

        // legacy used Object type to store items in List, so when we
        // retrieve the first item we will need to cast to String (from Object)
        // as we know that first item is a String (because we put a String into element 0)
        String s = (String) legacy.get(0);
        System.out.println(s.toUpperCase());

        // Integer n = (Integer) legacy.get(0); // could crash at runtime (wrong cast)

        Inventory<String> safe = new Inventory<>();
        // When the generic type (class) is given a type "String" we call it
        // a Parameterized Type (as it has been given its type via a parameter)
        // The compiler will enforce the use of only String types.

        safe.add("hello");
        // safe.add(123); // does not compile
        // The compiler does work for us, it checks that the types of the
        // elements are the same - avoiding type mismatch errors

        System.out.println(safe.get(0).toUpperCase());
    }
}