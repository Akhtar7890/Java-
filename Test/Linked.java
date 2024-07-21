import java.util.*;

public class Linked {
  public static Node head;
  int size;

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Insert at beginning
  public void insertFirst(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      this.size++;
      return;
    }
    newNode.next = head;
    head = newNode;
    this.size++;
  }

  // Insert at end
  public void insertEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      this.size++;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    this.size++;
  }

  // Function to insert node at Particular Index
  public void insertAtIndex(int data, int index) {
    Node newNode = new Node(data);
    if (head == null && index > 1) {
      System.out.println("No such index exist ");
      return;
    }
    if (index == 1) {
      insertFirst(data);
      this.size++;
      return;
    }

    int idx = 1;
    Node temp = head;
    while (temp != null && idx < index - 1) {
      temp = temp.next;
      idx++;
    }

    if (temp == null) {
      System.out.println("No position exist");
    } else {
      newNode.next = temp.next;
      temp.next = newNode;
      this.size++;
    }
  }

  // Printing the list
  public void printList() {
    if (head == null) {
      System.out.println("null");
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }

  // Reverse of linked list ------Space Optimized
  public Node reverseLinklist() {
    if (head == null || head.next == null) {
      return head;
    }
    Node prev = null;
    Node curr = head;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }

  // Duplicate element in linked list

  static void duplicateElement(Node head) {
    if (head == null) {
      System.out.println("Empty list");
      return;
    }
    Set<Integer> set = new HashSet<>();
    Node temp = head;
    System.out.print("Duplicates element : ");
    while (temp != null) {
      if (set.contains(temp.data)) {
        System.out.print(temp.data + " ");
      } else {
        set.add(temp.data);
      }
      temp = temp.next;
    }
  }

  // Check cycle;
  static boolean isCycle() {
    Node slow = head;
    Node fast = head;
    if (slow == null) {
      return true;
    }
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  // remove duplicate in sorted list
  static void removeDuplicateInSorted() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node temp = head;
    Node next = head.next;
    while (temp != null && temp.next != null) {
      if (temp.data != temp.next.data) {
        temp = temp.next;
      } else {
        temp = temp.next.next;
      }
    }
  }

  static void countNodesFrequency() {
    Map<Integer, Integer> m = new HashMap<>();
    Node curr = head;
    while (curr != null) {
      if (m.containsKey(curr.data)) {
        m.put(curr.data, m.getOrDefault(curr.data, 0) + 1);
      } else {
        m.put(curr.data, 1);
      }
      curr = curr.next;
    }
    for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
      System.out.print(entry.getKey() + "--");
      System.out.println(entry.getValue());
    }
  }

  static void printNthNodeFromGivenNode(int n, int nodeValue) {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    if (head.next != null && head.data == nodeValue && n == 1) {
      System.out.print(head.next.data);
      return;
    }
    Node curr = head;
    boolean found = false;
    int count = 0;
    while (curr != null) {
      if (curr.data == nodeValue) {
        found = true;
        break;
      }
      curr = curr.next;
    }
    Node temp = curr;
    if (found) {
      while (temp != null) {
        if (count == n) {
          System.out.println(temp.data);
        }
        count++;
        temp = temp.next;
      }
      if (temp == null && count < n) {
        System.out.println("No such node exist");
      }
    } else {
      System.out.println("Entered node value is not present in list");
    }
  }

  static void deleteNodeValue(Node head, int value) {
    if (head == null) {
      System.out.println("List is empty");
    }
    if (head.next == null && head.data == value) {
      System.out.println("Only one node exist " + head.data + " and its deleted");
      head = null;
      return;
    }
    if (head.next != null && head.data == value) {
      head = head.next;
    } else {
      Node prev = null;
      Node curr = head;
      boolean found = false;
      while (curr != null) {
        if (curr.data == value) {
          found = true;
          break;
        }
        prev = curr;
        curr = curr.next;
      }
      if (found) {
        prev.next = curr.next;
      } else {
        System.out.println("No such value exist");
      }
    }
  }

  // Merge Sorted list
  static Node mergeSortedList(Node head1, Node head2) {
    if (head1 == null || head2 == null) {
      return null;
    }
    Node dummy = new Node(-1);
    Node curr = dummy;
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        dummy.next = head1;
        head1 = head1.next;
      } else {
        dummy.next = head2;
        head2 = head2.next;
      }
    }
    curr.next = (head1 != null) ? head1 : head2;
    return dummy.next;
  }

  Node getMid(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  Node mergeList(Node left, Node right) {
    Node dummy = new Node(-1);
    Node curr = dummy;
    while (left != null && right != null) {
      if (left.data < right.data) {
        curr.next = left;
        curr = left;
        left = left.next;
      } else {
        curr.next = right;
        curr = right;
        right = right.next;
      }
    }
    curr.next = (left != null) ? left : right;
    return dummy.next;
  }

  public Node sortList(Node head) {
    if (head == null || head.next == null) {
      return null;
    }
    Node middle = getMid(head);
    Node right = middle.next;
    middle.next = null;
    Node left = head;
    left = sortList(left);
    right = sortList(right);

    return mergeList(left, right);
  }

  public static void main(String[] args) {
    Linked ll = new Linked();
    // Node head1 = ll.insertFirst(10);
    // head1 = ll.insertFirst(20);
    // head1 = ll.insertFirst(30);
    // head1 = ll.insertFirst(40);
    // head1 = ll.insertFirst(50);
    // head1 = ll.insertFirst(60);
    // Node head2 = ll.insertFirst(11);
    // head2 = ll.insertFirst(21);
    // head2 = ll.insertFirst(31);
    // head2 = ll.insertFirst(41);
    // head2 = ll.insertFirst(51);
    // head2 = ll.insertFirst(61);
    // Node ans = mergeSortedList(head1, head2);
    // ll.printList();
    ll.insertFirst(70);
    ll.insertFirst(60);
    ll.insertFirst(9);
    ll.insertFirst(5);
    ll.insertFirst(30);
    ll.insertFirst(2);
    ll.insertFirst(10);
    ll.printList();
    ll.sortList(head);
    ll.printList();
    // ll.insertAtIndex(99, 9);
    // ll.printList();
    // ll.printNthNodeFromGivenNode(22, 0);
    // 10->20->30->40->50->60->70->80
    /// ll.insertAtIndex(8, 5);
    // ll.reverseLinklist();
    // ll.duplicateElement(head);
    // head = new Node(1);
    // head.next = new Node(2);
    // head.next.next = new Node(3);
    // head.next.next.next = head;
    // System.out.println(isCycle());
    // ll.removeDuplicateInSorted();
    // ll.printList();
    // ll.countNodesFrequency();
    // ll.deleteNodeValue(0);
    // ll.printList();

  }
}
