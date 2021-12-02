package johnston.design_pattern.structure.adapter;

public class ClassicToModernAdapter implements ModernLaptop{
  private ClassicLaptop classicLaptop;

  public ClassicToModernAdapter(ClassicLaptop classicLaptop) {
    this.classicLaptop = classicLaptop;
  }

  @Override
  public void processData() {
    classicLaptop.processData();
  }

  @Override
  public void beginGaming() {
    System.out.println("Classic laptop is trying to run game");
  }
}
