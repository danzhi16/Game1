package StratsToAttack;
import Hero.Hero;
public class MagicAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target){
        int dmg=25;
        target.takeDamage(dmg);
        attacker.notifyObservers(attacker.getName()+" casts spell on "+target.getName()+" for "+dmg);
    }
}
