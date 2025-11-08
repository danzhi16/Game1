package Hero;
import StratsToAttack.RangedAttack;
import Visitors.Visitor;

public class Archer extends Hero {
    public Archer(String name){super(name,90,new RangedAttack());}
    public void accept(Visitor v){v.visit(this);}
}
