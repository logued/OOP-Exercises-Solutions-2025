package t08_generics_1.exercises.ex04;


public final class Exercise {
    public static void run() {

        //method where() takes a List and a predicate ( a lambda function
        // that returns true or false ) and is that is used to filter List elements
        java.util.ArrayList<String> a =
                Filters.where(java.util.List.of("Amy", "Bob", "Ada"), s -> s.startsWith("A"));

        java.util.ArrayList<Integer> b =
                Filters.where(java.util.List.of(5, 11, 12, 3), n -> n > 10);

        System.out.println(a); // [Amy, Ada]
        System.out.println(b); // [11, 12]
    }
}