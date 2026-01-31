package t08_generics_1.exercises.ex08;

public final class Exercise {

    public static void run() {

        // Create an array of type String and size 3
        String[] names = ArraysEx.newArray(String.class, 3);
        System.out.println(names.length); // 3

        Integer[] nums = ArraysEx.newArray(Integer.class, 2);
        nums[0] = 10;
        nums[1] = 20;

        System.out.println(nums[0] + ", " + nums[1]); // 10, 20
    }
}

