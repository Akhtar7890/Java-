package LinkedList;

public class Doubly {
  public static class Node {
    Node prev;
    int data;
    Node next;

    public Node(int data) {
      this.prev = null;
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;

  public void insertFirst(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      return;
    }
    head.prev = newNode;
    newNode.next = head;
    head = newNode;
  }

  // Print a doubly linked list
  public void printList() {
    if (head == null) {
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " <-> ");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }

  // Reverse a doublly linked list
  public void revDouble() {
    Node prev = null;
    Node curr = head;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      curr.prev = next;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  public static void main(String[] args) {
    Doubly dl = new Doubly();
    dl.insertFirst(45);
    dl.insertFirst(40);
    dl.insertFirst(41);
    dl.printList();
    dl.revDouble();
    dl.printList();

  }
}
