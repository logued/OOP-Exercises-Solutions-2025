package t09_generics_2.exercises.ex03;

public class Numbers {
    // method is a so-called Consumer - meaning it uses the values from
    // the list, but does not add values into the List
    // So, we use parameter <? extends T>

    public static double sumNumbers(java.util.List<? extends Number> nums) {
        if (nums == null || nums.isEmpty())
            return 0.0;

        double sum = 0.0;

        for (Number n : nums)
            sum += n.doubleValue();

        return sum;
    }
}