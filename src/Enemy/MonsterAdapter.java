package Enemy;
import Hero.Hero;
import StratsToAttack.AttackStrategy;
import HeroEventListener.HeroEventListener;
import java.util.*;
import Visitors.Visitor;
public class MonsterAdapter extends Hero {
    private Monster monster;
    private List<HeroEventListener> obs=new ArrayList<>();
    public MonsterAdapter(Monster monster){
        super(monster.getTitle(),100,null);
        this.monster=monster;
    }
    @Override
    public void attack(Hero target){
        monster.swing();
        target.takeDamage(10);
        notifyObservers(monster.getTitle()+" attacked "+target.getName()+" for 10 dmg!");
    }
    @Override
    public void takeDamage(int dmg){
        monster.hurt(dmg);
        notifyObservers(monster.getTitle()+" took "+dmg+" dmg!");
    }
    public void accept(Visitor v){v.visit(this);}
    @Override
    public void addObserver(HeroEventListener o){obs.add(o);}

    @Override
    public void notifyObservers(String msg){for(HeroEventListener o:obs)o.onEvent(msg);}
}
