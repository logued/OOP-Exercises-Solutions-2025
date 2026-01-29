package t04_collections2.exercises.ex01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public final class Exercise {

    public static void run() {
        System.out.println("ex01 started");

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(-2, -1, 0, 1, -6, 2, 3, 4, -5));
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value <= 0) {
                iterator.remove();    // removes the element that has just been traversed by using next()
            }
        }

        System.out.println("ex01 - list after removal = " + list);
    }
}

//Exercise 01
// What you’ll practice: Using a ListIterator to safely remove items during a scan.
// Why this matters: Index-based removal on a LinkedList is clumsy and easy to break; the iterator makes it simple and safe.
//
//        Task: Start with [-2, -1, 0, 1, 2, 3, 4]. Remove all non‑positive numbers (≤ 0) while iterating. No extra list.
//
//        Steps:
//
//Put the numbers into a LinkedList<Integer>.
//Get a ListIterator<Integer> it = list.listIterator();
//While you have a next item, read it. If it’s <= 0, call it.remove().
//Print the final list.
//Quick check: Output should be [1, 2, 3, 4].
//Hint: remove() acts on the last returned item from next().