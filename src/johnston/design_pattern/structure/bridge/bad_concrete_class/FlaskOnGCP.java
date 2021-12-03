package johnston.design_pattern.structure.bridge.bad_concrete_class;

import johnston.design_pattern.structure.bridge.framework.Framework;
import johnston.design_pattern.structure.bridge.server.Server;

public class FlaskOnGCP implements Framework, Server {
  @Override
  public String getFrameworkName() {
    return null;
  }

  @Override
  public void runFramework() {

  }

  @Override
  public String getServerName() {
    return null;
  }

  @Override
  public void uploadToCloud() {

  }
}
