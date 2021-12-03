package johnston.design_pattern.structure.bridge.deployment;

import johnston.design_pattern.structure.bridge.framework.Framework;
import johnston.design_pattern.structure.bridge.server.Server;

public class MyFirstDeployment extends Deployment {

  public MyFirstDeployment(Framework framework, Server server) {
    super(framework, server);
  }

  @Override
  public void deploymentStatus() {
    System.out.println(getFrameworkName() + " is deploying to " + getServerName());
  }

  @Override
  public String getFrameworkName() {
    return this.framework.getFrameworkName();
  }

  @Override
  public void runFramework() {
    this.framework.runFramework();
  }

  @Override
  public String getServerName() {
    return this.server.getServerName();
  }

  @Override
  public void uploadToCloud() {
    this.server.uploadToCloud();
  }
}
