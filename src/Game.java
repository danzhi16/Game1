import Hero.*;
import HeroEventListener.*;
import StratsToAttack.*;
import Enemy.*;

public class Game {
    public void start(){
        Hero h1=HeroFactory.createHero("warrior","Alikhan");
        Hero h2=HeroFactory.createHero("mage","Danial");
        Monster monster=new Monster("Ogre",120);
        Hero enemy=new MonsterAdapter(monster);

        HeroEventListener log=new LoggerObserver();
        HeroEventListener ann=new AnnouncerObserver();

        h1.addObserver(log);h1.addObserver(ann);
        h2.addObserver(log);h2.addObserver(ann);
        enemy.addObserver(log);enemy.addObserver(ann);

        System.out.println("=== Battle Start ===");
        h1.attack(h2);
        h2.attack(h1);
        h1.setAttackStrategy(new RangedAttack());
        h1.attack(enemy);
        enemy.attack(h2);
        h2.setAttackStrategy(new MagicAttack());
        h2.attack(enemy);
        System.out.println("=== Battle End ===");
    }
}
