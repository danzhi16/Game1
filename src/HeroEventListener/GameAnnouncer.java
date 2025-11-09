package HeroEventListener;

public final class GameAnnouncer {
    private static GameAnnouncer instance = new GameAnnouncer();
    private GameAnnouncer(){}
    public static GameAnnouncer getInstance(){
        return instance;
    }
    public void announce(String msg){
        System.out.println("[ANNOUNCER] "+msg);
    }
}
