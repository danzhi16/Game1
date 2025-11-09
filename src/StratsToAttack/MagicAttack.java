package StratsToAttack;
import Hero.Hero;
public class MagicAttack implements AttackStrategy {
    private static final int DAMAGE = 25;
    public void attack(Hero attacker, Hero target){
        target.takeDamage(DAMAGE);
        attacker.notifyObservers(attacker.getName()+" casts spell on "+target.getName()+" for "+DAMAGE);
    }
}
