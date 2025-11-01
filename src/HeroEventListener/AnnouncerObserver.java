package HeroEventListener;
public class AnnouncerObserver implements HeroEventListener {
    private final GameAnnouncer announcer=GameAnnouncer.getInstance();
    public void onEvent(String msg){
        announcer.announce(msg);
    }
}
