package johnston.design_pattern.creation.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public enum EnumIdGenerator {
  INSTANCE;
  AtomicInteger currId = new AtomicInteger(0);

  public int getInstance() {
    return currId.getAndIncrement();
  }

}
