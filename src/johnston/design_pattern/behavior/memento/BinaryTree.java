package johnston.design_pattern.behavior.memento;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class BinaryTree {
  static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }
}
