package StratsToAttack;
import Hero.Hero;
public class RangedAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target){
        int dmg=15;
        target.takeDamage(dmg);
        attacker.notifyObservers(attacker.getName()+" shoots arrow at "+target.getName()+" for "+dmg);
    }
}
