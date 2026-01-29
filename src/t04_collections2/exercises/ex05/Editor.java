package t04_collections2.exercises.ex05;

import java.util.Deque;
import java.util.LinkedList;

// Uses two Stack structures (LIFO - Last In First Out )
// Undo stack stores a history of previous states that existed as each change was made.
// Redo stack stores the previous states that existed before one or more calls to undo() were made.
//

class Editor {
    private final Deque<String> undoStack = new LinkedList<>();
    private final Deque<String> redoStack = new LinkedList<>();
    private String state = "";

    void type(String s) {
        undoStack.push(state);  // push the current state
        state += s;
        redoStack.clear();
    }

    boolean canUndo() {
        return !undoStack.isEmpty();
    }

    boolean canRedo() {
        return !redoStack.isEmpty();
    }

    void doUndo() {
        if (canUndo()) {
            redoStack.push(state);  // save current state before undo
            state = undoStack.pop();
        }
    }

    void doRedo() {
        if (canRedo()) {
            undoStack.push(state);  // save current sate
            state = redoStack.pop();
        }
    }

    String getState() {
        return state;
    }
}