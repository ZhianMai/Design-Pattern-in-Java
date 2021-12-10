package johnston.design_pattern.behavior.visitor;

import java.io.File;
import java.io.IOException;

public interface MyOutputVisitor {
  public void handleOutput(int i);
  public void handleOutput(double d);
  public void handleOutput(String s) throws IOException;
  public void handleOutput(File file);
}
