package t08_generics_1.exercises.ex08;

public final class Exercise {

    public static void run() {

        // Create an array of type String and size 3
        String[] names = ArraysEx.newArray(String.class, 3);
        names[0] = "First value";
        System.out.println("First element in STring array is : " + names[0]);
        System.out.println(names.length); // 3

        // Create an array of Integer elements
        Integer[] nums = ArraysEx.newArray(Integer.class, 2);
        nums[0] = 10;
        nums[1] = 20;

        System.out.println("Elements in the Integer array");
        System.out.println(nums[0] + ", " + nums[1]); // 10, 20
    }
}

