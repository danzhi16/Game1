package Hero;
import java.util.*;
import StratsToAttack.AttackStrategy;
import HeroEventListener.HeroEventListener;

public abstract class Hero {
    private String name;
    private int hp;
    private AttackStrategy strategy;
    private List<HeroEventListener> obs=new ArrayList<>();

    public Hero(String name,int hp,AttackStrategy strat){
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

    public void takeDamage(int dmg){
        hp-=dmg;
        notifyObservers(name+" HP: "+Math.max(hp,0));
        if(hp<=0) notifyObservers(name+" is defeated!");
    }

    public void addObserver(HeroEventListener o){obs.add(o);}
    public void removeObserver(HeroEventListener o){obs.remove(o);}
    public void notifyObservers(String msg){for(HeroEventListener o:obs) o.onEvent(msg);}
    public boolean isAlive(){return hp>0;}
    public String getName(){return name;}
}
