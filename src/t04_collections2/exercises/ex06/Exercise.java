package t04_collections2.exercises.ex06;
import java.util.LinkedList;

public final class Exercise {

    public static void run() {
        System.out.println("ex06 started");

        var eventQueue = new LinkedList<InputEvent>();

        eventQueue.add(new InputEvent("Move"));
        eventQueue.add(new InputEvent("Attack"));
        eventQueue.add(new InputEvent("Heal"));

        var it = eventQueue.listIterator();

        while (it.hasNext()) {
            InputEvent event = it.next();
            if (event.type.equals("Attack")) {
                it.add(new InputEvent("CameraShake"));  // insert a new event
            }

            if (event.type.equals("Heal")) {
                it.remove();     // removes the last element that we iterated over ( using it.next() )
            }
        }

        for(InputEvent event : eventQueue) {
            System.out.println(event);
        }
    }
}

//
//Exercise 06 — Game events with on‑the‑fly inserts (Games)
//What you’ll practice: Modifying a list as you process it.
//        Why this matters: Real-time systems often inject or cancel actions during handling.
//
//        Task: Start with a LinkedList<InputEvent> containing "Move", "Attack", "Heal". While scanning:
//
//If you see "Attack", insert a "CameraShake" right after it.
//If you see "Heal", remove it.

///  unclear - does this mean immediately after - if so we have to move the iterator back two elements to remove?????

//Steps:
//
//Define a tiny InputEvent class with a type field and toString().
//Iterate with ListIterator<InputEvent>.
//        On "Attack", call it.add(new InputEvent("CameraShake")).
//On "Heal", call it.remove().
//Print the final types in order.
//Quick check: Output has "CameraShake" immediately after "Attack" and no "Heal".
//Hint: Add before/after is relative to the iterator’s cursor—test with a tiny list first.