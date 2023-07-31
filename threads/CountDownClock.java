package threads;

public class CountDownClock implements Runnable {

    @Override
    public void run() {
        for (int t = 20; t >= 0; t--) {
            System.out.println("T minus " + t);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the exception, if needed
            }
        }
    }

    public static void main(String[] args) {
        CountDownClock countDownClock = new CountDownClock();
        Thread thread = new Thread(countDownClock);
        thread.start();
    }
}
