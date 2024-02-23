package LinkedList;

public class LinkedList {
  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;

  // Function to insert a node at Beginning Complexity O(n)
  public void insertFirst(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      return;
    }
    newNode.next = head;
    head = newNode;
  }

  // Function to insert a node at End
  public void insertEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  // Function to insert node at Particular Index
  public void insertAtIndex(int data, int index) {
    Node newNode = new Node(data);
    if (index == 0) {
      insertFirst(data);
      return;
    }
    int idx = 0;
    Node temp = head;
    while (idx < index - 1) {
      temp = temp.next;
      idx++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
  }

  // Remove a element from Starting
  public int removefirst() {
    if (head == null) {
      System.out.println("List is empty");
      return Integer.MIN_VALUE;
    } else if (head == tail) {
      int val = head.data;
      head = tail = null;
      return val;
    }
    int val = head.data;
    head = head.next;
    return val;
  }

  // Remove element from End
  public int removeLast() {
    if (head == null) {
      System.out.println("List is empty");
      return Integer.MIN_VALUE;
    } else if (head == tail) {
      int val = head.data;
      head = tail = null;
      return val;
    }
    Node temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    int val = temp.next.data;
    tail = temp;
    tail.next = null;
    return val;
  }

  // Function to print a list
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

  // Reverse a linked list O(n)
  public void reverseLinklist() {
    if (head == null) {
      System.out.println("List is empty");
    }
    Node prev = null;
    Node curr = tail = head;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  // Search a element in a list Iterative approach
  public int searchKey(int key) {
    if (head == null) {
      return -1;
    }
    int size = 0;
    Node temp = head;
    while (temp != null) {
      if (temp.data == key) {
        return size;
      }
      temp = temp.next;
      size++;
    }
    return -1;
  }

  // Search using recursion use ...call stack (n) space complexity O(n)
  public int helper(Node head, int key) {
    if (head == null) {
      return -1;
    }
    if (head.data == key) {
      return 0;
    }
    int indx = helper(head.next, key);
    if (indx == -1) {
      return -1;
    }
    return indx + 1;
  }

  public int recSearch(int key) {
    return helper(head, key);
  }

  // Find and remove Nth node from end Iterative approach
  // Very Important question
  public void deleteNthFromEnd(int n) {
    int size = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      size++;
    }
    if (n == size) { // Checks single node head condition
      head = head.next;// remove first
      return;
    }
    // size-n
    int i = 1;
    int indexTofind = size - n;
    Node prev = head;
    while (i < indexTofind) {
      prev = prev.next;
      i++;
    }
    prev.next = prev.next.next;
    return;
  }

  // Check a list is Pallindrome 1->2->2->1
  // We learn ->1.Slow fast concept 2.Reverse a half linkd list
  // Steps -> 1. Middle element find 2. Second half reverse 3. check (1st
  // half==2nd half)
  public Node findMid(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public boolean checkPallindrome() {
    if (head == null || head.next == null) {
      return true;
    }
    // Step 1. Middle element find
    Node midNode = findMid(head);
    // Step 2. Second half reverse
    Node prev = null;
    Node curr = midNode;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    Node right = prev;
    Node left = head;
    // Step 3. check (1st half ==2nd half)
    while (right != null) {
      if (left.data != right.data) {
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  }

  // Detect a cycle in list (Flyod's cycle finding algorithm)
  public static boolean isCycle() {
    Node slow = head;
    Node fast = head;
    if (slow == null) {
      return false;
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

  // Remove a cycle from a linked list
  public void removeCycle() {
    // detect cylce
    Node slow = head;
    Node fast = head;
    boolean cycle = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycle = true;
        break;
      }
    }
    if (cycle == false) {
      return;
    }
    // find meeting point
    slow = head;
    Node prev = null;
    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }
    // remove cycle->last.next=null
    prev.next = null;
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.insertFirst(56);
    // ll.insertFirst(66);
    // ll.insertFirst(90);
    // ll.insertFirst(81);
    // ll.insertEnd(1);
    // ll.insertEnd(2);
    // ll.insertEnd(1);
    // ll.insertEnd(2);
    // ll.insertAtIndex(99, 3);
    // ll.printList();// 81 90 56 99 88
    // System.out.println(ll.searchKey(56));
    // System.out.println(ll.searchKey(96));
    // System.out.println(ll.recSearch(56));
    // System.out.println(ll.recSearch(66));
    // System.out.println(ll.removeLast());
    // ll.printList();
    // ll.deleteNthFromEnd(3);
    // System.out.println(ll.checkPallindrome());
    // checking a cycle in linked list
    head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = head;
    System.out.println(isCycle());
  }
}
