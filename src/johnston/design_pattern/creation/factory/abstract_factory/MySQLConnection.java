package johnston.design_pattern.creation.factory.abstract_factory;

public class MySQLConnection implements FakeDBConnection {

  @Override
  public void about() {
    System.out.println("You're connecting to MySQL.");
  }
}
