package johnston.design_pattern.creation.factory.abstract_factory;

public class Tea implements Drink{

  @Override
  public void drink() {
    System.out.println("You're drinking tea.");
  }
}
