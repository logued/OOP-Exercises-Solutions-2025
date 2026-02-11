package t10_design_patterns_1.exercises.ex01;

// Attack Strategy describes the behaviour that occurs (consequences of) an attack
// i.e. the amount of Damage that is inflicted during the attack.

interface AttackStrategy
{
    int computeDamage(int baseDamage, int distanceMeters);
}

