package t09_generics_2.exercises.ex03;

public class Exercise {
    public static void run() {
        System.out.println(Numbers.sumNumbers(java.util.List.of(1, 2, 3)));      // 6.0
        System.out.println(Numbers.sumNumbers(java.util.List.of(0.5, 1.5, 2.0))); // 4.0
        System.out.println(Numbers.sumNumbers(null));                             // 0.0
    }
}