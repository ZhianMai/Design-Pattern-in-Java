package johnston.design_pattern.structure.adapter;

public class Main {

  public static void main(String[] args) {
    ClassicLaptop classicLaptopImpl = new ClassicLaptopImpl();
    ModernLaptop modernLaptop = new ClassicToModernAdapter(classicLaptopImpl);

    modernLaptop.processData();
    modernLaptop.beginGaming();
  }
}
