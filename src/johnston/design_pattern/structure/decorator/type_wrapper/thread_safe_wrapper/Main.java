package johnston.design_pattern.structure.decorator.type_wrapper.thread_safe_wrapper;

import johnston.design_pattern.structure.decorator.type_wrapper.basic.Counter;
import johnston.design_pattern.structure.decorator.type_wrapper.basic.IntegerCounter;

public class Main {
  public static void main(String[] args) {
    Counter<Integer> integerCounter = new IntegerCounter();
    Counter<Integer> safeIntegerCounter = new ThreadSafeCounter<>(integerCounter);

    System.out.println(safeIntegerCounter.incrementAndGet());
  }
}
