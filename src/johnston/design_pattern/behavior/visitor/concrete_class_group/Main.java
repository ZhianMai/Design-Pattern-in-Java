package johnston.design_pattern.behavior.visitor.concrete_class_group;

import johnston.design_pattern.behavior.visitor.MyOutputVisitorImpl;

public class Main {
  public static void main(String[] args) {
    TrickyOutputClass trickyOutputClass = new TrickyOutputClass(new MyOutputVisitorImpl());
    trickyOutputClass.outputInt();
    trickyOutputClass.outputDouble();
    trickyOutputClass.outputString();
    trickyOutputClass.outputFile();
  }
}
