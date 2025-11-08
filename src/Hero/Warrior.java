package Hero;
import StratsToAttack.MeleeAttack;
import Visitors.Visitor;

public class Warrior extends Hero {
    public Warrior(String name){super(name,100,new MeleeAttack());}
    public void accept(Visitor v){v.visit(this);}
}
