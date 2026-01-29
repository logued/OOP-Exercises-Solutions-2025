package t04_collections2.exercises.ex02;

import java.util.LinkedList;

public final class Exercise {

    public static void run() {
        System.out.println("ex02 started");

        var letters = new LinkedList<Character>();
        for (char c : "aaabbcc".toCharArray()) {    // create array of characters
            letters.add(c);                         // add characters to linkedList
        }

        var iter = letters.listIterator();        // type inference, it is of type ListIterator<Character>

        char previousCharacter = 0;             // a dummy character as there is no previous one yet

        while (iter.hasNext()) {
            char currentCharacter = iter.next();
            // when we encounter a change in character (e.g. from 'a' to 'b', we must
            // move the iterator back by one (to get between a and b) then, insert the bar character '|',
            // and finally move the iterator forward by one.
            if (previousCharacter != 0 && currentCharacter != previousCharacter){  // not at start AND characters are not same
                iter.previous();
                iter.add('|'); // mark boundary
                iter.next();
            }
            previousCharacter = currentCharacter;
        }
        System.out.println("ex02 - list after removal = " + letters);
    }
}


//Exercise 02 — Put markers between groups (Foundations)
//What you’ll practice: Inserting during iteration with it.add(...).
//Why this matters: Linked lists are great when you want to change the structure as you traverse.
//
//Task: Turn a a a b b c c c into a a a | b b | c c c by placing a '|' when the letter changes.
//
//Steps:
//
//Load characters into LinkedList<Character>.
//Walk with a ListIterator<Character> and remember the previous char.
//When the current char differs from previous, insert '|' using it.add('|').
//Print the list to confirm the markers appear at boundaries.
//Quick check: Your printed list shows | between a...b and b...c.
//       Hint: After add, call next() again before another remove/set.
//

