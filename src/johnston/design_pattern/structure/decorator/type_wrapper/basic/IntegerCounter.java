package johnston.design_pattern.structure.decorator.type_wrapper.basic;

import johnston.design_pattern.structure.decorator.type_wrapper.basic.Counter;

public class IntegerCounter implements Counter<Integer> {
  private int integer;

  public IntegerCounter() {
    integer = 0;
  }

  @Override
  public Integer incrementAndGet() {
    integer += 1;
    return integer;
  }

  @Override
  public void reset() {
    integer = 0;
  }
}
