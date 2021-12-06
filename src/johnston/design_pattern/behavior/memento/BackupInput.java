package johnston.design_pattern.behavior.memento;

import java.util.Deque;
import java.util.LinkedList;

public class BackupInput {
  private StringBuilder sb = new StringBuilder();
  private Deque<String> history = new LinkedList();

  public void input(String string) {
    sb.append(string);
  }

  public boolean delete(int counts) {
    if (counts > sb.length()) {
      return false;
    }

    while(counts-- > 0) {
      sb.deleteCharAt(sb.length() - 1);
    }
    return true;
  }

  public String getInput() {
    return sb.toString();
  }

  public boolean save() {
    if (sb.length() == 0) {
      return false;
    }
    history.addLast(sb.toString());
    return true;
  }

  public boolean restore() {
    if (history.peekLast() == null) {
      return false;
    }
    sb.delete(0, sb.length());
    sb.append(history.getLast());
    return true;
  }

  public String getCurrSave() {
    if (history.peekLast() == null) {
      return "";
    }
    return history.peekLast();
  }

  public boolean removeCurrSave() {
    if (history.peekLast() == null) {
      return false;
    }
    history.removeLast();
    return true;
  }
}
