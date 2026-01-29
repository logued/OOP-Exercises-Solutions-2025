package t04_collections2.exercises.ex05;

public final class Exercise {


    public static void run() {
        System.out.println("ex05 started");

        Editor editor = new Editor();

        editor.type("a");
        editor.type("b");
        editor.type("c");
        System.out.println(editor.getState());

        editor.doUndo();
        System.out.println(editor.getState());
        editor.doUndo();
        System.out.println(editor.getState());
        editor.doRedo();
        System.out.println(editor.getState());
        editor.doRedo();
        System.out.println(editor.getState());

        editor.type("d");
        System.out.println(editor.getState());
        editor.doRedo();
        System.out.println(editor.getState());
        editor.doUndo();
        System.out.println(editor.getState());

        editor.doRedo();
        System.out.println(editor.getState());

    }
}

//Exercise 05 — Undo & Redo (Software Dev)
//What you’ll practice: Two‑stack (two‑deque) undo/redo pattern.
//Why this matters: Editors, level tools, and UIs use this exact approach.
//
//Task: Implement type(text), undo(), and redo() methods. Try this sequence: type "a", then "b", then "c" → undo twice → redo once → type "Z" → print the final state.
//
//        Steps:
//
//Keep a String state, and two Deque<String>: undo and redo.
//type(s): undo.push(state), update state += s, then redo.clear().
//undo(): if undo not empty, redo.push(state), state = undo.pop().
//redo(): if redo not empty, undo.push(state), state = redo.pop().
//Run the sequence and print state.
//Quick check: Final state prints abZ.
//Hint: Any new typing clears the redo history.