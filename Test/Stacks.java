public class Stacks {
  class Node {
    int data;
    Node prev, next;

    Node(int data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  // Doubly Linked list
  public static Node head;
  public static Node tail;
  int size;

  void insertAtBegin(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      this.size++;
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
    this.size++;
  }

  // Insert at end
  void insertEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      this.size++;
      return;
    }
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
    this.size++;
  }

  // Insert at position
  void insertPos(int data, int index) {
    if (head == null && index > 1) {
      System.out.println("No such position found");
      return;
    }
    Node newNode = new Node(data);
    if (index == 1) {
      insertAtBegin(data);
      return;
    }
    int idx = 1;
    Node temp = head;
    while (temp != null && idx < index - 1) {
      temp = temp.next;
      idx++;
    }
    if (temp == null) {
      System.out.println("No such Position exist");
      return;
    } else {
      newNode.next = temp.next.prev;
      newNode.prev = temp;
      temp.next.prev = newNode;
      temp.next = newNode;
    }
  }

  static void traverse() {
    if (head == null) {
      System.out.println("List s empty");
      return;
    }
    if (head.next == null) {
      System.out.print(head.data + " ");
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

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
    Stacks st = new Stacks();
    st.insertAtBegin(5);
    st.insertAtBegin(6);
    st.insertAtBegin(7);
    st.insertAtBegin(8);
    st.traverse();
    System.out.println();
    st.insertEnd(9);
    st.traverse();
    System.out.println();
    // st.insertPos(88, 3);
    st.revDouble();
    st.traverse();
    System.out.println();
    System.out.println("Size : " + st.size);
  }
}
