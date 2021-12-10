package johnston.design_pattern.behavior.visitor.concrete_class_group;

import johnston.design_pattern.behavior.visitor.MyOutputVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class TrickyOutputClass {

  MyOutputVisitor visitor;
  Random rand;

  public TrickyOutputClass(MyOutputVisitor visitor) {
    this.visitor = visitor;
    rand = new Random();
  }

  public void outputInt() {
    int outputInt = rand.nextInt();
    visitor.handleOutput(outputInt);
  }

  public void outputDouble() {
    double outputDouble = rand.nextDouble();
    visitor.handleOutput(outputDouble);
  }

  public void outputString() {
    byte[] array = new byte[100];
    rand.nextBytes(array);
    String outputString = new String(array, Charset.defaultCharset());
    try {
      visitor.handleOutput(outputString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void outputFile() {
    File file = new File("unknown");
    visitor.handleOutput(file);
  }
}
