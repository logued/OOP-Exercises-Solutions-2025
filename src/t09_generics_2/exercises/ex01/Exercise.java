package t09_generics_2.exercises.ex01;

class Entity { }

class Enemy extends Entity { }

class Pickup extends Entity { }

public class Exercise {

    public static void run() {

        Enemy enemy = new Enemy();
        Entity entity = enemy; // normal inheritance works

        java.util.List<Enemy> enemies = new java.util.ArrayList<>();

        // java.util.List<Entity> entities = enemies;
        // Not allowed: List<Enemy> is not a List<Entity> (generics are invariant).

        System.out.println(entity);
        System.out.println(enemies.size());
    }
}