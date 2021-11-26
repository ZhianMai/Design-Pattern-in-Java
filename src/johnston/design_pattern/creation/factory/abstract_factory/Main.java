package johnston.design_pattern.creation.factory.abstract_factory;

public class Main {

  public static void main(String[] args) {
    Drink coffee = DrinkAbstractFactory.getDrink(DrinkList.COFFEE);
    coffee.drink();

    Drink tea = DrinkAbstractFactory.getDrink(DrinkList.TEA);
    tea.drink();

    Drink cocacola = DrinkAbstractFactory.getDrink(DrinkList.COCACOLA);
    cocacola.drink();
  }

}
