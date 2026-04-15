package t13_functional_interfaces.exercises.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise {

    public static void run() {

        List<PlayerEvent> eventsList = new ArrayList<>();
        eventsList.add(new PlayerEvent("player1", "KILL", 10));
        eventsList.add(new PlayerEvent("player2", "DAMAGE", 20));
        eventsList.add(new PlayerEvent("player3", "KILL", 30));

        Predicate<PlayerEvent> killPredicate = event -> event.getEventType().equals("KILL");

        Predicate<PlayerEvent> valueLessThanTenPredicate = event -> event.getValue() >= 10;

        // Exercise 2
        // Combine predicates using and(), or(), not()
        Predicate<PlayerEvent> combinedPredicate = killPredicate.and(valueLessThanTenPredicate);  // a combined predicate

        List<PlayerEvent> filteredList =
                Exercise.filterEvents(eventsList, combinedPredicate );

        System.out.println("After Combined KILL and value>=10 filter: " + filteredList);
    }

    public static List<PlayerEvent> filterEvents(List<PlayerEvent> events,
                                                 Predicate<PlayerEvent> rule) // functional interface
    {
        List<PlayerEvent> filteredEvents = new ArrayList<>();
        for (PlayerEvent event : events) {
            // Apply the rule (predicate) to each element in the list.
            // The predicate rule is applied by the test() method that is defined in the Predicate interface
            // (i.e. test each element by applying the predicate function - returning True or False
            //
            if (rule.test(event)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }
}

