import java.util.LinkedList;
import java.util.Queue;

public class BSTree {
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  static TreeNode insertNode(TreeNode root, int val) {
    if (root == null) {
      return root = new TreeNode(val);
    }
    if (root.val < val) {
      root.right = insertNode(root.right, val);
    } else {
      root.left = insertNode(root.left, val);
    }
    return root;
  }

  void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.val + " ");
    inOrder(root.right);
  }

  void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  void postOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.val + " ");
  }

  TreeNode findSuccessor(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  TreeNode deleteNode(TreeNode root, int value) {
    // search element
    if (root.val < value) {
      root.right = deleteNode(root.right, value);
    } else if (root.val > value) {
      root.left = deleteNode(root.left, value);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
      TreeNode InorderSuccessor = findSuccessor(root.right);
      root.val = InorderSuccessor.val;
      root.right = deleteNode(root.right, InorderSuccessor.val);
    }
    return root;
  }

  boolean searchingInBst(TreeNode root, int value) {
    if (root == null) {
      return false;
    }
    if (root.val == value) {
      return true;
    }
    if (root.val < value) {
      return searchingInBst(root.right, value);
    } else {
      return searchingInBst(root.left, value);
    }
  }

  void levelOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode curr = q.remove();
      System.out.print(curr.val + " ");
      if (curr.left != null) {
        q.add(curr.left);
      }
      if (curr.right != null) {
        q.add(curr.right);
      }
    }
  }

  int countAllNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countAllNodes(root.left) + countAllNodes(root.right) + 1;
  }

  int heightOfTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
  }

  // int depthOfTree(TreeNode root){
  // if(root==null){
  // return 0;
  // }
  // }
  public static void main(String[] args) {
    BSTree b = new BSTree();
    TreeNode root = null;
    root = insertNode(root, 5);
    insertNode(root, 6);
    insertNode(root, 1);
    insertNode(root, 7);
    insertNode(root, 2);
    insertNode(root, 4);
    insertNode(root, 3);
    insertNode(root, 8);
    // insertNode(root, 14);
    // insertNode(root, 30);
    // insertNode(root, 5);
    // insertNode(root, 18);
    // insertNode(root, 6);
    // insertNode(root, 21);
    // insertNode(root, 3);
    // insertNode(root, 7);
    // insertNode(root, 14);
    // insertNode(root, 5);
    // insertNode(root, 20);
    // insertNode(root, 5);
    // insertNode(root, 6);
    // insertNode(root, 18);
    // b.levelOrderTraversal(root);
    // System.out.println("Number of nodes : " + b.countAllNodes(root));
    System.out.print("height of tree : " + b.heightOfTree(root));
    System.out.println();
    b.inOrder(root);
    // b.deleteNode(root, 5);
    // System.out.println();
    // b.inOrder(root);
    // System.out.println();
    // b.preOrder(root);
    // System.out.println();
    // b.postOrder(root);
    // System.out.println(b.searchingInBst(root, 7));

  }
}
