package t13_functional_interfaces.exercises.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise {

    public static void run() {

        List<PlayerEvent> eventsList = new ArrayList<>();
        eventsList.add(new PlayerEvent("player1", "KILL", 10));
        eventsList.add(new PlayerEvent("player2", "DAMAGE", 20));
        eventsList.add(new PlayerEvent("player3", "KILL", 30));

        // define a (mapping) function that maps a PlayerEvent object to a player Id (String)
        Function<PlayerEvent, String> getPlayerIdFunction = playerEvent -> playerEvent.getPlayerId();

        List<String> resultList = mapTo(eventsList, getPlayerIdFunction);
        System.out.println(resultList);

        //TODO
        // Add code here to create a mapper function that
        // will map a PlayerEvent to a player Value
        // Call the mapTo() function to use this mapper function, and capture and display the
        // returned list.

    }

    /**
     * @param list   - a list of items of some type T
     * @param mapper - a function (functional interface) that maps a type T item to a type R item
     *               (note that the function is one that take a type T item and produces a type R item)
     * @param <T>
     * @param <R>
     * @return - a new list of items of type R (results)
     */
    public static <T, R> List<R> mapTo(List<T> list, Function<T, R> mapper) {

        List<R> resultsList = new ArrayList<>();    // create the results list

        for (T item : list) {
            // Apply the mapper function to each item in the list to get the resulting item.
            // (maps a PlayerEvent to a Player ID (String)

            resultsList.add(mapper.apply(item));
        }

        return resultsList;
    }
}