package t08_generics_1.exercises.ex02;

// GENERIC CLASS
final class UndoStack<T> {
    private final java.util.ArrayList<T> _items = new java.util.ArrayList<>();


    public void push(T item) {
        _items.add(item);
    }

    public T pop() {
        if (_items.isEmpty())
            return null;
        return _items.removeLast();
    }

    public T peek() {
        if (_items.isEmpty())
            return null;
        return _items.getLast();
    }

    public int size() {
        return _items.size();
    }
}

public final class Exercise {
    public static void run() {

        UndoStack<String> s = new UndoStack<>();

        s.push("MoveLeft");
        s.push("Jump");
        s.push("UsePotion");

        System.out.println(s.size()); // 3
        System.out.println(s.pop());  // UsePotion
        System.out.println(s.peek()); // Jump
        System.out.println(s.size()); // 2
    }
}