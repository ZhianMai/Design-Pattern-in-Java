package johnston.design_pattern.structure.composite;

import johnston.design_pattern.structure.bridge.framework.Framework;

import java.util.List;

public class LearnedFrameworks implements Framework {
  List<Framework> learnedFrameworks;

  public LearnedFrameworks(List<Framework> learnedFrameworks) {
    this.learnedFrameworks = learnedFrameworks;
  }

  public void addLearnedFramework(Framework framework) {
    learnedFrameworks.add(framework);
  }

  @Override
  public String getFrameworkName() {
    StringBuilder builder = new StringBuilder();
    builder.append("Framework I have learned: ");

    for (Framework f : learnedFrameworks) {
      builder.append(f.getFrameworkName() + ", ");
    }

    return builder.toString();
  }

  @Override
  public void runFramework() {
    StringBuilder builder = new StringBuilder();
    builder.append("Running frameworks I have learned: ");

    for (Framework f : learnedFrameworks) {
      builder.append(f.getFrameworkName() + ", ");
    }

    System.out.println(builder.toString());
  }
}
