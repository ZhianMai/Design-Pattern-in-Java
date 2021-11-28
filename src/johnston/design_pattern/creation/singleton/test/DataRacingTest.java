package johnston.design_pattern.creation.singleton.test;

import johnston.design_pattern.creation.singleton.EnumIdGenerator;
import johnston.design_pattern.creation.singleton.InnerStaticSafeIdGenerator;
import johnston.design_pattern.creation.singleton.SafeLazyIdGenerator;
import johnston.design_pattern.creation.singleton.UnsafeLazyIdGenerator;

import java.util.concurrent.CountDownLatch;

public class DataRacingTest {
  private static final int DEFAULT_THREAD_AMOUNT = 20;
  public static void main(String[] args) {
    CountDownLatch counter = new CountDownLatch(DEFAULT_THREAD_AMOUNT);
    // Init before all threads can avoid data racing
    // BasicLazyIdGenerator.getInstance().getId();
    
    class GetIdThread extends Thread {
      @Override
      public void run() {
        counter.countDown();
        try {
          counter.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        // int id = SafeLazyIdGenerator.getInstance().getId();
        // int id = UnsafeLazyIdGenerator.getInstance().getId();
        // int id = InnerStaticSafeIdGenerator.getInstance().getId();
        int id = EnumIdGenerator.INSTANCE.getId();
        System.out.println(this.getName() + " got an id: " + id);
      }
    }

    Thread[] threadList = new Thread[DEFAULT_THREAD_AMOUNT];
    for (int i = 0; i < DEFAULT_THREAD_AMOUNT; i++) {
      threadList[i] = new GetIdThread();
      threadList[i].start();
    }
  }
}
