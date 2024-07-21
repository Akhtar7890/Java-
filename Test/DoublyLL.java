public class DoublyLL {
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
  public static Node head = null;
  public static Node tail = null;
  int size;

  void insertAtBegin(int data) {
    Node newNode = new Node(data);
    if (head == null && tail == null) {
      head = tail = newNode;
      this.size++;
      return;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
      this.size++;
    }
  }

  // Insert at end
  void insertEnd(int data) {
    Node newNode = new Node(data);
    if (head == null && tail == null) {
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
      this.size++;
      return;
    }
    if (index == size + 1) {
      insertEnd(data);
      this.size++;
      return;
    }
    int idx = 1;
    Node temp = head;
    while (temp != null && idx < index - 1) {
      temp = temp.next;
      idx++;
    }
    if (temp == null || idx > index + 1) {
      System.out.println("No such Position exist");
      return;
    } else {
      newNode.next = temp.next;
      newNode.prev = temp;
      temp.next.prev = newNode;
      temp.next = newNode;
      this.size++;
    }
  }

  static void traverse() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  void delelteHead() {
    if (head == null) {
      System.out.print("List is empty");
    }
    if (head.next == null) {
      System.out.println("Only one node " + head.data + " exist and it is delelted");
      head = tail = null;
      this.size--;
    } else {
      head = head.next;
      head.prev = null;
      this.size--;
    }
  }

  void deleteTail() {
    if (head == null) {
      System.out.print("List is empty");
    }
    if (head.next == null) {
      System.out.println("Only one node " + head.data + " exist and it is delelted");
      head = tail = null;
      this.size--;
    }
    Node curr = head;
    while (curr.next != tail) {
      curr = curr.next;
    }
    curr.next.prev = null;
    curr.next = null;
  }

  void deleteAtPos(int index) {
    if (head == null || index < 1) {
      System.out.print("List is empty");
    }
    if (head.next == null && index == 1) {
      System.out.println("Only one node " + head.data + " exist and it is delelted");
      this.size--;
    }
    if (index == 1) {
      delelteHead();
      this.size--;
      return;
    }
    if (index == size) {
      deleteTail();
      this.size--;
      return;
    }
    Node curr = head;
    int idx = 1;
    while (curr != null && idx < index - 1) {
      curr = curr.next;
      idx++;
    }
    if (curr == null) {
      System.out.println("No such index exist");
    } else {
      curr.next = curr.next.next;
      curr.next.prev = curr;
    }
    this.size--;
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

    // Multiple cursor ctrl+shift+L
    DoublyLL st = new DoublyLL();
    st.insertEnd(8);
    st.insertEnd(9);
    st.insertAtBegin(10);
    st.insertAtBegin(11);
    st.insertAtBegin(12);
    // st.insertPos(77, 6);
    // st.traverse();
    // st.delelteHead();
    st.traverse();
    System.out.println();
    /// st.deleteAtPos(3);
    // st.deleteTail();
    st.revDouble();
    st.traverse();

  }
}
