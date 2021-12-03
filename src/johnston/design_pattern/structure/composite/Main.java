package johnston.design_pattern.structure.composite;

import johnston.design_pattern.structure.bridge.framework.Django;
import johnston.design_pattern.structure.bridge.framework.Flask;
import johnston.design_pattern.structure.bridge.framework.Framework;
import johnston.design_pattern.structure.bridge.framework.Spring;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Framework> frameworkList = new ArrayList<>();
    frameworkList.add(new Spring());
    frameworkList.add(new Django());
    frameworkList.add(new Flask());

    Framework learnedFramework = new LearnedFrameworks(frameworkList);

    // I only learned Spring :)
    System.out.println(learnedFramework.getFrameworkName());
    learnedFramework.runFramework();
  }
}
