package johnston.design_pattern.creation.singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A singleton class with lazy init using static inner class. This is thread-safe and no lock or
 * check required.
 */
public class InnerStaticSafeIdGenerator implements Serializable, Cloneable {
  private final AtomicInteger currId = new AtomicInteger(0);

  private static class Impl {
    private static final InnerStaticSafeIdGenerator GLOBAL_ID_GENERATOR =
        new InnerStaticSafeIdGenerator();
  }

  private InnerStaticSafeIdGenerator() {
    /**
     * Adding this check to avoid malicious reflection copying.
     */
    if (Impl.GLOBAL_ID_GENERATOR != null) {
      throw new InstantiationError("Not allowed to created this object again!");
    }

    System.out.println("\n***Singleton InnerStaticSafeIdGenerator init finished***\n");
  }

  public static InnerStaticSafeIdGenerator getInstance() {
    return Impl.GLOBAL_ID_GENERATOR;
  }

  public int getId() {
    return currId.getAndIncrement();
  }

  /**
   * This method indicates when deserializing this Singleton class, return the original object.
   * This method is to designate the object to return when calling ObjectInputStream().
   */
  protected Object readResolve() {
    return Impl.GLOBAL_ID_GENERATOR;
  }

  /**
   * Avoid using clone() to make deep copy, if this singleton class extends or implements cloneable
   */
  @Override
  public final Object clone() throws CloneNotSupportedException {
    // throw new CloneNotSupportedException("Not allow to clone this singleton class");
    return getInstance();
  }
}
