package StratsToAttack;
import Hero.Hero;
public class MeleeAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target){
        int dmg=20;
        target.takeDamage(dmg);
        attacker.notifyObservers(attacker.getName()+" hits "+target.getName()+" with sword for "+dmg);
    }
}
