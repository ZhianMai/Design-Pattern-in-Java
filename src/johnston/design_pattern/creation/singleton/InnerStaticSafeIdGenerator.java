package johnston.design_pattern.creation.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A singleton class with lazy init using static inner class. This is thread-safe and no lock or
 * check required.
 */
public class InnerStaticSafeIdGenerator {
  private final AtomicInteger currId = new AtomicInteger(0);

  private static class Impl {
    private static final InnerStaticSafeIdGenerator GLOBAL_ID_GENERATOR =
        new InnerStaticSafeIdGenerator();
  }



  private InnerStaticSafeIdGenerator() {
    System.out.println("\n***Singleton InnerStaticSafeIdGenerator init finished***\n");
  }

  public static InnerStaticSafeIdGenerator getInstance() {
    return Impl.GLOBAL_ID_GENERATOR;
  }

  public int getId() {
    return currId.getAndIncrement();
  }
}
