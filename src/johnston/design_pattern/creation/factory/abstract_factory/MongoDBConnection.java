package johnston.design_pattern.creation.factory.abstract_factory;

public class MongoDBConnection implements FakeDBConnection {

  @Override
  public void about() {
    System.out.println("You are connecting to MongoDB.");
  }
}
