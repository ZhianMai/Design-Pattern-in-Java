package johnston.design_pattern.structure.decorator.basic_wrapper;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    SafeInteger safeInt = new SafeInteger(0);

    System.out.println(safeInt.add(Integer.MAX_VALUE));
    // System.out.println(safeInt.incrementAndGet());
    safeInt.set(Integer.MIN_VALUE);
    // System.out.println(safeInt.decrementAndGet());
  }
}
