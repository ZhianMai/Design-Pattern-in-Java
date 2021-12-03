package johnston.design_pattern.structure.bridge.server;

public class Aws implements Server {

  @Override
  public String getServerName() {
    return "AWS";
  }

  @Override
  public void uploadToCloud() {
    System.out.println("uploading to AWS");
  }
}
