package Hero;
import java.util.*;
import StratsToAttack.AttackStrategy;
import HeroEventListener.HeroEventListener;
import Visitors.Visitor;

public abstract class Hero {
    private final String name;
    private int hp;
    private AttackStrategy strategy;
    private final List<HeroEventListener> observers=new ArrayList<>();


    public Hero(String name,
                int hp,
                AttackStrategy strat){
        this.name=name;
        this.hp=hp;
        this.strategy=strat;
    }

    public void setAttackStrategy(AttackStrategy s){
        this.strategy=s;
        notifyObservers(name+" changed strategy to "+s.getClass().getSimpleName());
    }

    public void attack(Hero target){
        if(isAlive()) strategy.attack(this,target);
        else notifyObservers(name+" is dead and can't attack");
    }
    public abstract void accept(Visitor v);

    public void takeDamage(int dmg){
        int before = hp;
        hp = Math.max(hp - dmg, 0);
        notifyObservers(name + " took " + dmg + " dmg, HP: " + before + " -> " + hp);
        if(hp==0) notifyObservers(name+" is defeated!");
    }
    public void heal(int amt) {
        if (!isAlive()) {
            notifyObservers(name + " is dead and cannot be healed.");
            return;
        }
        int before = hp;
        hp += amt;
        notifyObservers(name + " healed +" + amt + " HP: " + before + " -> " + hp);
    }

    public void addObserver(HeroEventListener o){
        if (o != null && !observers.contains(o)) observers.add(o);
    }
    public void notifyObservers(String msg){
        for(HeroEventListener o:observers) o.onEvent(msg);}

    public boolean isAlive(){return hp>0;}
    public String getName(){return name;}
    public int getHp(){return hp;}
}
