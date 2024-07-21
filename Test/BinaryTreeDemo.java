import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BinaryTreeDemo {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  TreeNode createTreeNode() {
    TreeNode root = null;
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    if (num == -1) {
      return null;
    }
    root = new TreeNode(num);
    System.out.print("Enter left child of " + root.val + " : ");
    root.left = createTreeNode();
    System.out.print("Enter right child of " + root.val + " : ");
    root.right = createTreeNode();
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

  private TreeNode deleteNode(TreeNode node, Set<Integer> set, List<TreeNode> ans) {
    if (node == null) {
      return null;
    }
    node.left = deleteNode(node.left, set, ans);
    node.right = deleteNode(node.right, set, ans);

    if (set.contains(node.val)) {
      if (node.left != null) {
        ans.add(node.left);
      }
      if (node.right != null) {
        ans.add(node.right);
      }
      return null;
    }
    return node;
  }

  // delete in Binary Tree
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    if (root == null) {
      return null;
    }
    List<TreeNode> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int i : to_delete) {
      set.add(i);
    }
    deleteNode(root, set, ans);
    if (!set.contains(root.val)) {
      ans.add(root);
    }
    return ans;
  }

  TreeNode findInorderSuccessor(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  TreeNode delBinaryTree(TreeNode root, int value) {
    if (root == null) {
      return null;
    }
    root.left = delBinaryTree(root.left, value);
    root.right = delBinaryTree(root.right, value);
    if (root.val != value) {
      return null;
    } else {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left != null) {
        return root.right;
      } else if (root.right != null) {
        return root.right;
      }
      TreeNode successor = findInorderSuccessor(root.right);
      root.val = successor.val;
      root.right = delBinaryTree(root.right, successor.val);
    }
    return root;
  }

  public static void main(String[] args) {
    BinaryTreeDemo bt = new BinaryTreeDemo();
    TreeNode root = bt.createTreeNode();
    bt.inOrder(root);
    System.out.println();
    bt.preOrder(root);
    System.out.println();
    bt.postOrder(root);

  }
}
