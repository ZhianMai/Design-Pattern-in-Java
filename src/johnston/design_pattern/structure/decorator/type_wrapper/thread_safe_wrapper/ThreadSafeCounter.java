package johnston.design_pattern.structure.decorator.type_wrapper.thread_safe_wrapper;

import johnston.design_pattern.structure.decorator.type_wrapper.basic.Counter;

public class ThreadSafeCounter<E> implements Counter {
  Counter<E> counter;

  public ThreadSafeCounter(Counter<E> counter) {
    this.counter = counter;
  }

  @Override
  public E incrementAndGet() {
    synchronized (counter) {
      return counter.incrementAndGet();
    }
  }

  @Override
  public void reset() {
    synchronized (counter) {
      counter.reset();
    }
  }
}
