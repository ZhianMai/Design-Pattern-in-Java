package johnston.design_pattern.structure.bridge.framework;

public class Spring implements Framework{
  @Override
  public String getFrameworkName() {
    return "Spring";
  }

  @Override
  public void runFramework() {
    System.out.println("Spring framework is running");
  }
}
