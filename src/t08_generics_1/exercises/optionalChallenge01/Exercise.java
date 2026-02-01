package t08_generics_1.exercises.optionalChallenge01;

final class ObjectPool<T> {
    private final java.util.function.Supplier<T> _factory;  // functional interface
    private final java.util.ArrayList<T> _pool = new java.util.ArrayList<>();

    public ObjectPool(java.util.function.Supplier<T> factory) {
        if (factory == null)
            throw new NullPointerException("factory must not be null");
        _factory = factory;  // reference to code that instantiates a new StringBuilder
    }

    public T acquire() {
        if (_pool.isEmpty())
            return _factory.get();  // invokes code to create new StringBuilder object

        return _pool.removeLast();  // get reference to existing last string
    }

    public void release(T obj) {
        // Choice: we will NOT allow null releases
        if (obj == null)
            throw new NullPointerException("obj must not be null");

        _pool.add(obj);  // adds object to end of list, to keep it in the pool
    }
}

public final class Exercise {

    public static void run() {
        ObjectPool<StringBuilder> pool = new ObjectPool<>(StringBuilder::new);

        StringBuilder a = pool.acquire();
        a.append("hi");
        pool.release(a);

        StringBuilder b = pool.acquire();
        System.out.println(a == b); // true (reused)
    }
}