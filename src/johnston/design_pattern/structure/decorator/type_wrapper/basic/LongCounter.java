package johnston.design_pattern.structure.decorator.type_wrapper.basic;

public class LongCounter implements Counter<Long> {
  long longNum;

  public LongCounter() {
    longNum = 0;
  }

  @Override
  public Long incrementAndGet() {
    longNum += 1;
    return longNum;
  }

  @Override
  public void reset() {
    longNum = (long)0;
  }
}
