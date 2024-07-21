public class CircularList {
  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  public static Node head = null;
  public static Node last = null;

  // Java program for the above operation
  static Node addToEmpty(Node last, int data) {
    if (last != null) {
      return last;
    }
    Node newNode = new Node(data);
    last = newNode;
    newNode.next = last;
    return last;
  }

  // insert at beginning
  static Node insertAtBegin(Node last, int data) {
    if (last == null) {
      return addToEmpty(last, data);
    }
    Node newNode = new Node(data);
    newNode.next = last.next;
    last.next = newNode;
    return last;
  }

  // Insert at end
  static Node insertAtEnd(Node last, int data) {
    if (last == null) {
      return addToEmpty(last, data);
    }
    Node newNode = new Node(data);
    newNode.next = last.next;
    last.next = newNode;
    last = newNode;
    return last;

  }

  // insert at position after node
  static Node insertAtPosition(Node last, int data, int pos) {
    if (last == null)
      return null;

    Node temp;
    temp = last.next;
    do {
      if (temp.data == pos) {
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.next = temp.next;
        temp.next = temp;

        if (temp == last)
          last = temp;
        return last;
      }
      temp = temp.next;
    } while (temp != last.next);

    System.out.println(pos + " not present in the list.");
    return last;
  }

  static void printList(Node last) {
    Node p;
    if (last == null) {
      System.out.println("List is empty.");
      return;
    }
    p = last.next;
    do {
      System.out.print(p.data + " ");
      p = p.next;
    } while (p != last.next);
  }

  // Length of circular linked list
  static int findLength(Node last) {
    if (last == null) {
      return 0;
    }
    if (last.next == head) {
      return 1;
    }
    Node temp = head;
    int size = 1;
    while (temp.next != last) {
      size++;
      temp = temp.next;
    }
    return size;
  }

  // Swap first and last node in cl
  static Node findLastNode(Node head) {
    Node curr = head;
    while (curr.next != head) {
      curr = curr.next;
    }
    return curr;
  }

  static void swapFirstAndLast(Node head) {
    Node last = findLastNode(head);
    Node first = head;
    int num = first.data;
    first.data = last.data;
    last.data = num;
  }

  public static void main(String[] args) {
    CircularList cl = new CircularList();
    last = cl.insertAtEnd(last, 1);
    last = cl.insertAtEnd(last, 2);
    last = cl.insertAtEnd(last, 3);
    last = cl.insertAtEnd(last, 4);
    // head = new Node(1);
    // head.next = new Node(2);
    // head.next.next = new Node(3);
    // head.next.next.next = new Node(4);
    // head.next.next.next.next = head;
    cl.printList(last);
    System.out.println("Length :" + findLength(last));
    // swapFirstAndLast(last);
    // cl.printList(last);
  }
}
