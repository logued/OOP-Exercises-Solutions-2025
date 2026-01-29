package t04_collections2.exercises.ex06;

import java.util.LinkedList;
import java.util.ListIterator;

class InputEvent {
    final String type;

    InputEvent(String t) {
        type = t;
    }

    @Override
    public String toString() {
        return "InputEvent{" +
                "type='" + type + '\'' +
                '}';
    }
}
