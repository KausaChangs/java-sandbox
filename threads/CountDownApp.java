package threads;
import java.util.*;

public class CountDownApp
    {
        public static void main(String[] args)
        {
            Thread clock = new Thread(new CountDownClock());


           ArrayList<Runnable> events = new ArrayList<Runnable>();

           events.add(new LaunchEvent(16, "FLood the pad!"));
           events.add(new LaunchEvent(6, "Start the engines!"));
           events.add(new LaunchEvent(0, "Liftoff!"));

            clock.start();

            for (Runnable liftOffEvents: events){
                new Thread(liftOffEvents).start();
            }
        }
    }