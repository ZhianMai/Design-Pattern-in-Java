package johnston.design_pattern.structure.decorator.type_wrapper.basic;

public class ShortCounter implements Counter<Short> {
  short shortNum;

  public ShortCounter() {
    shortNum = 0;
  }

  @Override
  public Short incrementAndGet() {
    shortNum += (short)1;
    return shortNum;
  }

  @Override
  public void reset() {
    shortNum = 0;
  }
}
