package johnston.design_pattern.creation.factory.abstract_factory;

public class DrinkAbstractFactory {
  private DrinkAbstractFactory() {
  }

  public static Drink getDrink(DrinkList drink) {
    switch (drink) {
      case TEA:
        return new Tea();
      case COFFEE:
        return new Coffee();
      case COCACOLA:
        return new Cocacola();
      default:
        return null;
    }
  }
}
