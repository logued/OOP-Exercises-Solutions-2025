package t10_design_patterns_1.exercises.ex01;

// a particular (concrete) way of calculating damage in a MeleeAttack

class MeleeAttack implements AttackStrategy
{
    @Override
    public int computeDamage(int baseDamage, int distanceMeters)
    {
        if (distanceMeters > 2)  // a melee (hand-to-hand combat) must be close up to have any effect
            return 0;

        return baseDamage + 5;
    }

    // a melee attack at further than 2 meters causes no damage
    // a melee attack from 2 meters or less inflicts a damage of base + 5 units
}
