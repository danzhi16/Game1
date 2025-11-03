package Enemy;
public class Monster {
    private String title;
    private int health;
    public Monster(String title,int health){
        this.title=title;
        this.health=health;
    }
    public void swing(){
        System.out.println(title+" swings its claws!");
    }
    public void hurt(int dmg){
        health-=dmg;
        System.out.println(title+" now has "+Math.max(health,0)+" HP");
        if(health<=0) System.out.println(title+" is defeated!");
    }
    public String getTitle(){return title;}
    public boolean isAlive(){return health>0;}
}
