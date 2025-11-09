package Visitors;
import Enemy.MonsterAdapter;
import Hero.*;

public interface Visitor {
    void visit(Warrior w);
    void visit(Archer a);
    void visit(Mage m);
    void visit(MonsterAdapter ma);
}
