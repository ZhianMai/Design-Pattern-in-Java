package johnston.design_pattern.creation.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread-safe lazy init singleton. It uses double-check and synchronized to ensure exactly
 * init once. Missing double-check or synchronized can compromise the thread-safety.
 */
public class SafeLazyIdGenerator {
  private final AtomicInteger currId = new AtomicInteger(0);
  private static SafeLazyIdGenerator GLOBAL_ID_GENERATOR;

  private SafeLazyIdGenerator() {
    System.out.println("\n***Singleton SafeLazyIdGenerator init finished***\n");
  }

  public static SafeLazyIdGenerator getInstance() {
    // Possible data racing here
    if (GLOBAL_ID_GENERATOR == null) {
      synchronized (SafeLazyIdGenerator.class) {
        if (GLOBAL_ID_GENERATOR == null) {
          GLOBAL_ID_GENERATOR = new SafeLazyIdGenerator();
        }
      }
    }
    return GLOBAL_ID_GENERATOR;
  }

  public int getId() {
    return currId.getAndIncrement();
  }
}