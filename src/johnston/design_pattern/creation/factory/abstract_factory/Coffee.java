package johnston.design_pattern.creation.factory.abstract_factory;

public class Coffee implements Drink{
  @Override
  public void drink() {
    System.out.println("You're drinking coffee.");
  }
}
