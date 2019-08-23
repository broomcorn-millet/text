package CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo implements Runnable {
    static final CountDownLatch latch=new CountDownLatch(10);
   static final Demo demo=new Demo();
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            latch.countDown();
        }

    }
    public static void main(String[]args) throws InterruptedException {
        ExecutorService exc= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exc.submit(demo);
        }
        latch.await();
        System.out.println("fire");
        exc.shutdown();
    }
}
