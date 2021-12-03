package johnston.design_pattern.structure.bridge.framework;

public class Flask implements Framework{
  @Override
  public String getFrameworkName() {
    return "Flask";
  }

  @Override
  public void runFramework() {
    System.out.println("Flask framework is running");
  }
}
