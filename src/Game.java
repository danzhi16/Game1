import Hero.*;
import HeroEventListener.*;
import StratsToAttack.*;

public class Game {
    public void start(){
        Hero h1=HeroFactory.createHero("warrior","Arthas");
        Hero h2=HeroFactory.createHero("mage","Merlin");

        HeroEventListener log=new LoggerObserver();
        HeroEventListener ann=new AnnouncerObserver();

        h1.addObserver(log);h1.addObserver(ann);
        h2.addObserver(log);h2.addObserver(ann);

        h1.attack(h2);
        h2.attack(h1);
        h1.setAttackStrategy(new RangedAttack());
        h1.attack(h2);
        h2.setAttackStrategy(new MagicAttack());
        h2.attack(h1);
    }
}
