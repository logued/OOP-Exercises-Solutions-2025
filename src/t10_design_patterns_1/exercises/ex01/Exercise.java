package t10_design_patterns_1.exercises.ex01;

public final class Exercise
{
    public static void run()
    {
        // create Enemy objects and set their attach strategy
        //
        Enemy skeleton = new Enemy("Skeleton", 10, new MeleeAttack());
        Enemy archer = new Enemy("Archer", 10, new RangedAttack());

        // various distances attack is made from
        int[] distances = new int[] { 1, 5, 12 };

        // attack a skeleton Enemy from various distances and report the
        // damage inflicted
        for (int d : distances)
        {
            System.out.println(skeleton.getName() + " at " + d + "m: " + skeleton.attack(d));
        }

        // attack archer Enemy from various distances
        for (int d : distances)
        {
            System.out.println(archer.getName() + " at " + d + "m: " + archer.attack(d));
        }
    }
}

