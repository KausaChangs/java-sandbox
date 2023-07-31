package threads;

public class LaunchEvent implements Runnable {

    private int start;
    private String message;

    public LaunchEvent(int start, String message) {
        this.start = start;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20000 - (start * 1000));
        } catch (InterruptedException e) {
            // Handle the exception, if needed
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        LaunchEvent launchEvent = new LaunchEvent(10, "Launch in 10 Seconds!");
        Thread thread = new Thread(launchEvent);
        thread.start();
    }
}
