package Visitors;
import Hero.*;
import Enemy.MonsterAdapter;
public class HealingVisitor implements Visitor {
    private static final int WARRIOR_HEAL = 20;
    private static final int ARCHER_HEAL = 30;
    private static final int MAGE_HEAL = 25;
    private static final int MONSTER_HEAL = 8;
    public void visit(Warrior w){w.heal(WARRIOR_HEAL);}
    public void visit(Archer a){a.heal(ARCHER_HEAL);}
    public void visit(Mage m){m.heal(MAGE_HEAL);}
    public void visit(MonsterAdapter ma){ma.heal(MONSTER_HEAL);}


}

