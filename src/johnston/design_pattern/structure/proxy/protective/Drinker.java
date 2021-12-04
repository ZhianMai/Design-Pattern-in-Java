package johnston.design_pattern.structure.proxy.protective;

public class Drinker implements Liquor {
  private String name;

  public Drinker(String name) {
    this.name = name;
  }

  @Override
  public void drink() {
    System.out.println(this.name + " is drinking maotai.");
  }
}
