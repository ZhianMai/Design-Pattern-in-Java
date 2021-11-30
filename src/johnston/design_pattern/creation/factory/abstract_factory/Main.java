package johnston.design_pattern.creation.factory.abstract_factory;

public class Main {

  public static void main(String[] args) {
    FakeDBConnection postgresConn = DrinkAbstractFactory.getDrink(DrinkList.POSTGRES);
    postgresConn.about();

    FakeDBConnection mongodbConn = DrinkAbstractFactory.getDrink(DrinkList.MONGODB);
    mongodbConn.about();

    FakeDBConnection mysqlConn = DrinkAbstractFactory.getDrink(DrinkList.MYSQL);
    mysqlConn.about();
  }

}
