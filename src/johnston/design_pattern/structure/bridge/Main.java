package johnston.design_pattern.structure.bridge;

import johnston.design_pattern.structure.bridge.deployment.Deployment;
import johnston.design_pattern.structure.bridge.deployment.MyFirstDeployment;
import johnston.design_pattern.structure.bridge.framework.Framework;
import johnston.design_pattern.structure.bridge.framework.Spring;
import johnston.design_pattern.structure.bridge.server.Aws;
import johnston.design_pattern.structure.bridge.server.GCP;
import johnston.design_pattern.structure.bridge.server.Server;

public class Main {
  public static void main(String[] args) {
    Framework spring = new Spring();
    Server aws = new Aws();

    Deployment myDeployment = new MyFirstDeployment(spring, aws);
    System.out.println("Server is: " + myDeployment.getServerName());
    System.out.println("Framework is: " + myDeployment.getFrameworkName());
    myDeployment.deploymentStatus();

    Server gcp = new GCP();
    myDeployment.setServer(gcp);
    System.out.println("\nServer has changed to: " + myDeployment.getServerName());
    System.out.println("Framework is: " + myDeployment.getFrameworkName());
  }
}
