package johnston.design_pattern.creation.factory.abstract_factory;

public class DrinkAbstractFactory {
  private DrinkAbstractFactory() {
  }

  public static FakeDBConnection getDrink(DrinkList drink) {
    switch (drink) {
      case MYSQL:
        return new MySQLConnection();
      case POSTGRES:
        return new PostgresSQL();
      case MONGODB:
        return new MongoDBConnection();
      default:
        return null;
    }
  }
}
