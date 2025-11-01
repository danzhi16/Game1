package HeroEventListener;
public class LoggerObserver implements HeroEventListener {
    public void onEvent(String msg){
        System.out.println("[LOG] "+msg);
    }
}
