package StratsToAttack;
import Hero.Hero;
public class RangedAttack implements AttackStrategy {
    private static final int DAMAGE = 15;
    public void attack(Hero attacker, Hero target){
        target.takeDamage(DAMAGE);
        attacker.notifyObservers(attacker.getName()+" shoots arrow at "+target.getName()+" for "+DAMAGE);
    }
}
