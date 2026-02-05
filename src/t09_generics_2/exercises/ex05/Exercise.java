package t09_generics_2.exercises.ex05;

public class Exercise {
    public static void run() {
        java.util.List<Integer> src = java.util.List.of(1, 2, 3);

        java.util.ArrayList<Number> dst1 = new java.util.ArrayList<>();
        java.util.ArrayList<Object> dst2 = new java.util.ArrayList<>();

        Copier.copy(src, dst1);
        Copier.copy(src, dst2);

        System.out.println(dst1); // [1, 2, 3]
        System.out.println(dst2); // [1, 2, 3]
    }
}