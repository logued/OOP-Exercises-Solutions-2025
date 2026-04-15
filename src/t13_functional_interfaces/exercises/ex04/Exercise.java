package t13_functional_interfaces.exercises.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Exercise {

    public static void run() {

        List<PlayerEvent> eventsList = new ArrayList<>();
        eventsList.add(new PlayerEvent("player1", "KILL", 10));
        eventsList.add(new PlayerEvent("player2", "DAMAGE", 20));
        eventsList.add(new PlayerEvent("player3", "KILL", 30));

        // define a Consumer function that prints a playerEvent
        // (We use a Consumer as we need to simply consume a value and do something with it
        // - but not change it, nor return anything)

        Consumer<PlayerEvent> printPlayerEventFunction = playerEvent -> System.out.println(playerEvent.toString());

        forEach(eventsList, printPlayerEventFunction);

        //TODO
        // Define a Consumer function that will print a list of only the Player IDs
        // (use getPlayerID() )
        // Call the forEach() method with this consumer and check the output.
    }

    /**
     * Our own implementation of te forEach method.
     * This method is available with Collections API
     *
     * @param list
     * @param action - the Consumer function that carries out an action
     * @param <T>
     */
    public static <T> void forEach(List<T> list, Consumer<T> action) {

        for (T item : list) {
            // Apply the 'action' function to each item in the list to get the resulting item.

            action.accept(item);        // accept (consumes an item and does something with that item)
        }

    }
}
