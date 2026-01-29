package t04_collections2.exercises.ex03;

import java.util.LinkedList;
import java.util.List;

public final class Exercise {

    public static void run() {
        System.out.println("ex03 started");

        LinkedList<String> words = new LinkedList<>(List.of("Java","is","fun"));

        // OR, using type inference - "var"
        // var words = new LinkedList<>(List.of("Java","is","fun"));

        var iter = words.listIterator();        // type inference, it is of type ListIterator<Character>

        System.out.print("Words in order: ");
        while (iter.hasNext()) {
            String word = iter.next();  // iterate over a word and store that word
            System.out.print(word + " ");
        }

        // Iterator is now beyond the last word,
        // so we can walk backwards through words to print in reverse
        System.out.print("\nWords in reverse: ");
        while (iter.hasPrevious ()) {
            String word = iter.previous();  // iterate over a word and store that word
            System.out.print(word + " ");
        }
        System.out.println();

    }
}


//Exercise 03 — Walk forward, then backward (Foundations)
//What you’ll practice: Using hasPrevious()/previous() to move backwards.
//Why this matters: ListIterator is bidirectional; this is a core linked-list skill.
//
//Task: Given a list of words, print the sentence forward, then print the same words in reverse using the same iterator.
//
//Steps:
//
//Build LinkedList<String> words = List.of("Java","is","fun") → as a new LinkedList<>(...).
//Use it.next() to print "Java is fun".
//Without creating a new iterator, loop with hasPrevious()/previous() to print "fun is Java".
//        (Optional) If the last word equals "foo", replace it with it.set("bar") before the reverse print.
//Quick check: You see both forward and reverse prints.
//        Hint: previous() returns the item before the cursor.

