package t08_generics_1.exercises.ex06;

// Generic class definition
// Class Registry is a WRAPPER class around a HashMap (Map) that
// does not allow 'null' as a value for the Key. (Normal Map allows a null key)
// It uses Generics to make it usable for any <Key, Value> pair types.

final class Registry<K, V> {

    private final java.util.HashMap<K, V> _map = new java.util.HashMap<>();

    public void put(K key, V value) {
        if (key == null)
            throw new NullPointerException("key must not be null");
        _map.put(key, value);
    }

    public V get(K key) {
        if (key == null)
            throw new NullPointerException("key must not be null");
        return _map.get(key);
    }

    public boolean containsKey(K key) {
        if (key == null)
            throw new NullPointerException("key must not be null");
        return _map.containsKey(key);
    }
}

public final class Exercise {

    public static void run() {
        Registry<String, Integer> scores = new Registry<>();
        scores.put("Zara", 100);
        scores.put("Kai", 55);
        //scores.put(null, 80);  // will throw exception - which is the purpose of the wrapper

        System.out.println(scores.containsKey("Zara")); // true
        System.out.println(scores.get("Kai"));          // 55
        System.out.println(scores.get("Nope"));         // null
    }
}