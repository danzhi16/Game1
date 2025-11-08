package Hero;
import StratsToAttack.MagicAttack;
import Visitors.Visitor;

public class Mage extends Hero {
    public Mage(String name){super(name,80,new MagicAttack());}
    public void accept(Visitor v){v.visit(this);}
}
