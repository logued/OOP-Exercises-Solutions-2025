package t04_collections2.exercises.ex08;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class Exercise {

    public static void run() {
        System.out.println("ex08 started");

        LinkedList<Integer> listA = new LinkedList<>(List.of(2, 2, 3, 4, 4, 4, 6,7,7));
        LinkedList<Integer> listB = new LinkedList<>(List.of(1, 3, 3, 4, 5, 5, 8));

        ListIterator<Integer> iteratorA = listA.listIterator();
        ListIterator<Integer> iteratorB = listB.listIterator();

        while(iteratorB.hasNext()) {

            int val = iteratorB.next();

            while(iteratorA.hasNext()) {

                ///TODO complete

            }
            System.out.println(iteratorB.next());




        }

    }

}

//
//Exercise 08 — Merge two sorted lists (Intermediate)
//What you’ll practice: In‑place ordered merge using two iterators.
//Why this matters: Avoids extra lists and highlights iterator power.
//
//        Task: Merge sorted list B into sorted list A (ascending order), without creating a third list.
//
//Steps:
//
//Make copies: A = new LinkedList<>(List.of(...)), B = new LinkedList<>(List.of(...)).
//Hold ListIterator<Integer> ai = A.listIterator(); and standard Iterator<Integer> bi = B.iterator(); (or another ListIterator).
//While bi has items, peek the next b. Move ai forward until a >= b, then ai.add(b) and advance only bi.
//When ai hits the end, add the rest of B.
//Print A to confirm order.
//Quick checks: A is still sorted and contains all items of both.
//Hint: Duplicates are fine—don’t skip them.
