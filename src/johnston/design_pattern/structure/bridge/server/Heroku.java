package johnston.design_pattern.structure.bridge.server;

public class Heroku implements Server {

  @Override
  public String getServerName() {
    return "Heroku";
  }

  @Override
  public void uploadToCloud() {
    System.out.println("uploading to Heroku");
  }
}
