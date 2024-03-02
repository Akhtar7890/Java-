package BinaryTree;

import BinaryTree.BT.Node;
import BinaryTree.BT.Node.BinaryTree;

public class PreOrder {

  public static void PreOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    PreOrder(root.left);
    PreOrder(root.right);
  }

  public static void postOrder(Node root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    System.out.print("PreOrder : ");
    PreOrder(root);
    System.out.println();
    System.out.print("PostOrder : ");
    postOrder(root);

  }
}
