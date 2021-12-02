package johnston.design_pattern.structure.adapter;

public class ClassicLaptopImpl implements ClassicLaptop {

  @Override
  public void processData() {
    System.out.println("Classic laptop is processing data");
  }
}
