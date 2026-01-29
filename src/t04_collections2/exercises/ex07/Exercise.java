package t04_collections2.exercises.ex07;

import java.util.LinkedList;
import java.util.List;

public final class Exercise {

    public static void run() {
        System.out.println("ex07 started");

        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        var iter = list.iterator();
        int count = 0;

        while (list.size() > 1) {  // keep going until only one element left
            while (iter.hasNext()) {
                iter.next();
                count++;
                if (count == 3) { // we have iterated over a third element, so delete it
                    iter.remove();
                    count = 0;
                }
            }       // we carry the count into the next iteration of the loop to get circular list effect

            iter = list.iterator(); // reset iterator to start (but not the counter)
        }
        System.out.println(list);
    }

}

//
//Exercise 07 — The Josephus game (Intermediate)
//What you’ll practice: Circular traversal and removal with a linked list.
//Why this matters: It forces you to manage iterator position carefully.
//
//Task: N players sit in a circle. Remove every k‑th player until one remains. For example, N=7, k=3 → winner is 4.
//
//Steps:
//
//Build LinkedList<Integer> of players 1..N.
//Use a ListIterator<Integer> and a counter step.
//Each time step == k, remove the current player and reset step.
//When you hit the end, wrap by creating a new iterator at list.listIterator() and continue.
//Print the last remaining ID.
//Quick check: With N=7, k=3, output 4.
//Hint: Keep step going across wraps; only reset it on removals.