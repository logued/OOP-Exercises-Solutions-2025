package t10_design_patterns_1.exercises.ex01;

// Enemy is the so-called "context" w.r.t. the Strategy Pattern.
// It is the class that executes the attack but by using the
// (dependency injected) set specific 'concrete' attack mechanism.

class Enemy
{
    private String _name;
    private int _baseDamage;

    // store the particular (concrete) attack strategy
    private AttackStrategy _strategy;

    // when we instantiate an Enemy we pass in the chosen attack strategy
    public Enemy(String name, int baseDamage, AttackStrategy strategy)
    {
        _name = name;
        _baseDamage = baseDamage;
        _strategy = strategy;
    }

    public String getName()
    {
        return _name;
    }

    public int attack(int distanceMeters)
    {
        return _strategy.computeDamage(_baseDamage, distanceMeters);
    }
}