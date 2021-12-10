package johnston.design_pattern.behavior.visitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyOutputVisitorImpl implements MyOutputVisitor {
  @Override
  public void handleOutput(int i) {
    System.out.println("Print integer on console: " + i);
  }

  @Override
  public void handleOutput(double d) {
    System.out.println("Print double on console if > 0: " + (d > 0 ? d : ""));
  }

  @Override
  public void handleOutput(String s) {
    String fileName = "output";

    System.out.println("Save string to file named " + fileName);
    File outFile = new File(fileName);
    Writer writer = null;

    try {
      outFile.createNewFile();
      writer = new FileWriter(fileName);
      writer.write(s);
      writer.write("\n");
    } catch (IOException e) {
      System.out.println("Failed to write to file");
      e.printStackTrace();
    } finally {
      try {
        writer.close();
      } catch (IOException e) {
        System.out.println("Failed to close writer.");
        e.printStackTrace();
      }
    }
  }

  @Override
  public void handleOutput(File file) {
    System.out.println("Only check if file exists: " + file.exists());
  }
}
