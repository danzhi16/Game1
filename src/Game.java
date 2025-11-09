import Hero.*;
import HeroEventListener.*;
import StratsToAttack.*;
import Enemy.*;
import Visitors.HealingVisitor;
import Visitors.Visitor;

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
        printHp(h1,h2,enemy);
        h1.attack(h2);
        h2.attack(h1);
        printHp(h1,h2);
        h1.setAttackStrategy(new RangedAttack());
        h1.attack(enemy);
        enemy.attack(h2);
        printHp(h1,h2,enemy);
        h2.setAttackStrategy(new MagicAttack());
        h2.attack(enemy);
        printHp(h2,enemy);

        Visitor healer=new HealingVisitor();
        h1.accept(healer);
        h2.accept(healer);
        enemy.accept(healer);
        h2.accept(healer);
        h1.accept(healer);
        printHp(h1,h2,enemy);

        System.out.println("=== Battle End ===");
    }

    private void printHp(Hero... heroes){
    System.out.println("-- HP Status --");
    for (Hero h : heroes){
        System.out.println(h.getName()+" HP="+h.getHp());
    }
}
}
