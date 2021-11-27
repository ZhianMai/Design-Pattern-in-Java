package johnston.design_pattern.creation.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A singleton class with lazy init. This is not thread-safe because data racing happens in
 * getInstance() method.
 */
public class UnsafeLazyIdGenerator {
  private final AtomicInteger currId = new AtomicInteger(0);
  private static UnsafeLazyIdGenerator GLOBAL_ID_GENERATOR;

  private UnsafeLazyIdGenerator() {
    System.out.println("\n***Singleton UnsafeLazyIdGenerator init finished***\n");
  }

  public static UnsafeLazyIdGenerator getInstance() {
    // Possible data racing here
    if (GLOBAL_ID_GENERATOR == null) {
      GLOBAL_ID_GENERATOR = new UnsafeLazyIdGenerator();
    }
    return GLOBAL_ID_GENERATOR;
  }

  public int getId() {
    return currId.getAndIncrement();
  }
}
