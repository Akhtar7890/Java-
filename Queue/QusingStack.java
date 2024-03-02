package Queue;

import java.util.Stack;;

public class QusingStack {
  static class Qu {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static boolean isEmpty() {
      return s1.isEmpty();
    }

    // Add--> O(n)
    public static void add(int data) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
      s1.push(data);
      while (!s2.isEmpty()) {
        s1.push(s2.pop());
      }
    }

    // Remove--> O(1)
    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
      }
      return s1.pop();
    }

    // Peek--> O(1)
    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
      }
      return s1.peek();
    }
  }

  public static void main(String[] args) {
    Qu q = new Qu();
    q.add(1);
    q.add(2);
    q.add(3);
    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}
