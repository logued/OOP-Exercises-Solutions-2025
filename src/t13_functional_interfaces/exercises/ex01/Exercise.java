package t13_functional_interfaces.exercises.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise {

    public static void run() {

        List<PlayerEvent> eventsList = new ArrayList<>();
        eventsList.add(new PlayerEvent("player1", "KILL", 10));
        eventsList.add(new PlayerEvent("player2", "DAMAGE", 20));
        eventsList.add(new PlayerEvent("player3", "KILL", 30));

        // call the filterEvents() method, passing in the List and
        // the Predicate function (called a Lambda).
        // Because we are passing a lambda function as an argument,
        // the corresponding parameter must be a Functional Interface type.
        //
        List<PlayerEvent> filteredList1 =
                Exercise.filterEvents(eventsList,
                            event -> event.getEventType().equals("KILL"));

        System.out.println("After KILL filter: " + filteredList1);

        // call filterEvents() passing in the List but, this time,
        // a different Predicate function that evaluates "value>=10"
        //
        List<PlayerEvent> filteredList2 =
                Exercise.filterEvents(eventsList,
                        event -> event.getValue() >= 10);

        System.out.println("After \"value>=10\" filter: " + filteredList2);

        // We can assign a Predicate (lambda function) to a variable
        // and pass that variable into the function as an argument.
        // The Type of the variable must be a Predicate<T> that deals with
        // PlayerEvent type objects (so, Predicate<PlayerEvent> )

        Predicate<PlayerEvent> damagePredicate =
                event -> event.getEventType().equals("DAMAGE");

        List<PlayerEvent> filteredList3 =
                Exercise.filterEvents(eventsList, damagePredicate );

        System.out.println("After DAMAGE filter: " + filteredList3);

        Predicate<PlayerEvent> killPredicate = event -> event.getEventType().equals("KILL");

    }

    public static List<PlayerEvent> filterEvents(List<PlayerEvent> events,
                                                 Predicate<PlayerEvent> rule) // functional interface
    {
        List<PlayerEvent> filteredEvents = new ArrayList<>();
        for (PlayerEvent event : events) {
            // Apply the rule (predicate) to each element in the list.
            // The rule is applied by the test() method that is defined in the Predicate interface
            // (i.e. test each element using the predicate and return True or False
            if (rule.test(event)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }

}

