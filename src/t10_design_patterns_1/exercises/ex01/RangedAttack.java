package t10_design_patterns_1.exercises.ex01;

// a particular (concrete) way of calculating damage in a RangedAttack

class RangedAttack implements AttackStrategy
{
    @Override
    public int computeDamage(int baseDamage, int distanceMeters)
    {
        if (distanceMeters > 10)
            return 0;

        return baseDamage;
    }
}