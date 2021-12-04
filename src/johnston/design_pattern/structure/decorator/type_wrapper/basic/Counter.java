package johnston.design_pattern.structure.decorator.type_wrapper.basic;

public interface Counter<E> {
  public E incrementAndGet();
  public void reset();
}
