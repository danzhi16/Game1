package Visitors;
import Hero.*;
import Enemy.MonsterAdapter;
public class HealingVisitor implements Visitor {
    public void visit(Warrior w){w.heal(20);}
    public void visit(Archer a){a.heal(30);}
    public void visit(Mage m){m.heal(25);}
    public void visit(MonsterAdapter ma){ma.heal(8);}


}

