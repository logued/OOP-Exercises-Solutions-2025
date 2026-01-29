package t02_ordering.exercises.ex01;
//Call an exercise from t02_ordering.exercises.ex01.Main using the fully-qualified path to the class (e.g. t01_arrays.challenges.ce01.Exercise):



public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run(){
        System.out.println("Running challenge exercise 02...");
        t02_ordering.exercises.ex01.Exercise.run();



    }
}

/* Notes:
 - Keep packages aligned with notes/topics, e.g. t01_arrays.exercises.ex01_basics.
 - Multiple t02_ordering.exercises.ex01.Main/Exercise class names are fine because packages make them unique.
 - Shared helpers live in package 'common', e.g. 'common.FileUtils'.
*/