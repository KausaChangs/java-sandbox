import java.util.ArrayList;
// version 2.0 of the Countown application

public class CoordinatedCountdownApp{
    public static void main(String[] args){
       CountDownClock clock = new CountDownClock(20);

       ArrayList<Runnable> events = new ArraList<Runnable>();

       events.add(new LaunchEvent(16, "Flood the pad!", clock));
       events.add(new LaunchEvent(6, "Start the engines", clock));
       events.add(new LaunchEvent(0, "LiftOff!", clock));

       clock.start();

       for(Runnable e : events){
        new Thread(e).start();
       }
    }
}