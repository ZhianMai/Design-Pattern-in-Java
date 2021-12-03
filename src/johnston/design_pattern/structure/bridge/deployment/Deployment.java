package johnston.design_pattern.structure.bridge.deployment;

import johnston.design_pattern.structure.bridge.framework.Framework;
import johnston.design_pattern.structure.bridge.server.Server;

public abstract class Deployment implements Framework, Server {
  protected Framework framework;
  protected Server server;

  public Deployment(Framework framework, Server server) {
    this.framework = framework;
    this.server = server;
  }

  public abstract void deploymentStatus();

  public void setFramework(Framework framework) {
    this.framework = framework;
  }

  public void setServer(Server server) {
    this.server = server;
  }
}
