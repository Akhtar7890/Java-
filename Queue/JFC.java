package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class JFC {
  public static void main(String[] args) {

    // Queue is Interface we cannot create a object of Interface
    // Queue can be implemented by using two class 1)LinkedList Class 2)
    // ArrayDequeue class
    // Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q = new ArrayDeque<>();
    q.add(1);
    q.add(2);
    q.add(3);
    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}
