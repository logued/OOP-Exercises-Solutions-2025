package t09_generics_2.exercises.ex04;

public class Exercise {
    public static void run() {
        java.util.ArrayList<Object> out = new java.util.ArrayList<>();
        Fillers.fill(out, "hi", 3);

        System.out.println(out); // [hi, hi, hi]
    }
}