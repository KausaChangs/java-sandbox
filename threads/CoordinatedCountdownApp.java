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

    interface TimeMonitor{
        int getTime();
    }

    class CountDownClock extends Thread implements TimeMonitor{
        private int t;

        public CountDownClock(int start){
            this.t = start;
        }

        public void run(){
            for (; t >= 0; t--){
                System.out.println("T minus "+ t);
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedExcepton e){
                    
                }
            }
        }

        public int getTime(){
            return t;
        }
    }


}