//need to fix this

import java.util.ArrayList;


public class CoordinatedCountdownApp {
    public static void main(String[] args) {
         
        CoordinatedCountdownApp app = new CoordinatedCountdownApp();
        CountDownClock clock = app.new CountDownClock(20);

        ArrayList<Runnable> events = new ArrayList<>();

        events.add(clock.new LaunchEvent(16, "Flood the pad!"));
        events.add(clock.new LaunchEvent(6, "Start the engines"));
        events.add(clock.new LaunchEvent(0, "LiftOff!"));

        clock.start();

        for (Runnable e : events) {
            new Thread(e).start();
        }
    }

    interface TimeMonitor {
        int getTime();
    }

    class CountDownClock extends Thread implements TimeMonitor {
        private int t;

        public CountDownClock(int start) {
            this.t = start;
        }

        public void run() {
            for (; t >= 0; t--) {
                System.out.println("T minus " + t);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Handle InterruptedException (e.g., print an error message)
                }
            }
        }

        public int getTime() {
            return t;
        }

        class LaunchEvent implements Runnable {
            private int start;
            private String message;

            public LaunchEvent(int start, String message) {
                this.start = start;
                this.message = message;
            }

            public void run() {
                boolean eventDone = false;
                while (!eventDone) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // Handle InterruptedException (e.g., print an error message)
                    }
                    if (getTime() <= start) {
                        System.out.println(this.message);
                        eventDone = true;
                    }
                }
            }
        }
    }
}
