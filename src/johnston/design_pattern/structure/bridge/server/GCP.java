package johnston.design_pattern.structure.bridge.server;

public class GCP implements Server {

  @Override
  public String getServerName() {
    return "GCP";
  }

  @Override
  public void uploadToCloud() {
    System.out.println("uploading to GCP");
  }
}
