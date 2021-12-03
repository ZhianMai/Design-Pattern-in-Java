package johnston.design_pattern.structure.bridge.framework;

public class Django implements Framework{
  @Override
  public String getFrameworkName() {
    return "Django";
  }

  @Override
  public void runFramework() {
    System.out.println("Django framework is running");
  }
}
