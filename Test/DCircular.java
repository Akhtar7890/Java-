public class DCircular {
  class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.prev = null;
      this.next = null;
    }
  }

  public ListNode head = null;
  public ListNode tail = null;

  void addAtHead(int val) {
    ListNode node = new ListNode(val);
    if (head == null) {
      head = node;
      node.prev = head;
      node.next = head;
      return;
    }
    ListNode temp = head;
    while (temp.next != head) {
      temp = temp.next;
    }
    temp.next = node;
    node.prev = temp;
    head.prev = node;
    node.next = head;
    head = node;
  }

  void addAtEnd(int val) {
    ListNode node = new ListNode(val);
    if (head == null) {
      node.next = node.prev = node;
      head = node;
      return;
    }
    ListNode curr = head;
    while (curr.next != head) {
      curr = curr.next;
    }
    node.next = curr.next;
    head.prev = node;
    curr.next = node;
    node.prev = curr;
  }

  void displayList() {
    if (head == null) {
      System.out.println("Empty list");
      return;
    }
    ListNode temp = head;
    while (temp.next != head) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }

  int lengthOfList() {
    if (head == null) {
      return 0;
    }
    int len = 0;
    ListNode curr = head;
    while (curr.next != head) {
      curr = curr.next;
      len++;
    }
    return len;

  }

  public static void main(String[] args) {
    DCircular dcll = new DCircular();
    dcll.addAtHead(3);
    dcll.addAtHead(3);
    dcll.addAtHead(3);
    dcll.addAtHead(3);
    // dcll.addAtEnd(7);
    dcll.displayList();
    System.out.println("Length : " + dcll.lengthOfList());
  }
}
