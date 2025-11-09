package StratsToAttack;
import Hero.Hero;
public class MeleeAttack implements AttackStrategy {
    private static final int DAMAGE = 20;
    public void attack(Hero attacker, Hero target){
        target.takeDamage(DAMAGE);
        attacker.notifyObservers(attacker.getName()+" hits "+target.getName()+" with sword for "+DAMAGE);
    }
}
