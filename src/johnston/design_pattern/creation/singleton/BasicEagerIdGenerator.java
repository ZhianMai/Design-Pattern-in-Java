package johnston.design_pattern.creation.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A singleton class with eager init. This is thread-safe because init happens when loading class.
 * If the init process is resources-consuming like connecting to remote database (and perhaps
 * nobody use it!), then this method is not recommended.
 */
public class BasicEagerIdGenerator {
  private final AtomicInteger CURR_ID = new AtomicInteger(0);
  private static final BasicEagerIdGenerator GLOBAL_ID_GENERATOR = new BasicEagerIdGenerator();

  private BasicEagerIdGenerator() {
    System.out.println("\n***Singleton BasicEagerIdGenerator init finished***\n");
  }

  public static BasicEagerIdGenerator getInstance() {
    return GLOBAL_ID_GENERATOR;
  }

  public int getId() {
    return CURR_ID.getAndIncrement();
  }
}
