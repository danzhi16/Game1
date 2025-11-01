package HeroEventListener;
public class GameAnnouncer {
    private static GameAnnouncer instance;
    private GameAnnouncer(){}
    public static GameAnnouncer getInstance(){
        if(instance==null) instance=new GameAnnouncer();
        return instance;
    }
    public void announce(String msg){
        System.out.println("[ANNOUNCER] "+msg);
    }
}
