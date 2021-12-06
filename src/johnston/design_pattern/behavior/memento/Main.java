package johnston.design_pattern.behavior.memento;

public class Main {
  public static void main(String[] args) {
    BackupInput input = new BackupInput();
    input.input("abcdef");
    System.out.println("First input: " + input.getInput());
    input.save();
    input.delete(3);
    System.out.println("Delete 3 char: " + input.getInput());
    input.delete(2);
    System.out.println("Delete 2 char: " + input.getInput());
    input.restore();
    System.out.println("Restore to the first save point: " + input.getInput());
  }
}
