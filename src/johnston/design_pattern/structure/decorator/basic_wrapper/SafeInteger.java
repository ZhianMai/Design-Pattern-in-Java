package johnston.design_pattern.structure.decorator.basic_wrapper;

public class SafeInteger {
  private int integer;

  public SafeInteger(int integer) {
    this.integer = integer;
  }

  public int get() {
    return integer;
  }

  public int set(int integer) {
    this.integer = integer;
    return integer;
  }

  public int incrementAndGet() {
    if (integer == Integer.MAX_VALUE) {
      throw new ArithmeticException("Integer max value overflow");
    }
    return ++integer;
  }

  public int decrementAndGet() {
    if (integer == Integer.MIN_VALUE) {
      throw new ArithmeticException("Integer min value overflow");
    }
    return --integer;
  }

  public int add(int a) {
    if (a > 0 && (Integer.MAX_VALUE - a > integer)) {
      throw new ArithmeticException("Integer max value overflow");
    } else if (a < 0 && (Integer.MIN_VALUE + a > integer)) { // i - a < min
      throw new ArithmeticException("Integer min value overflow");
    }
    integer += a;
    return integer;
  }
}
