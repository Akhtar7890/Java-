package Stack;

import java.util.Stack;

public class JCF {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    System.out.println(s.isEmpty());
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }

  }
}
