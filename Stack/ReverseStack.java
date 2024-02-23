package Stack;

import java.util.Stack;

public class ReverseStack {
  // push an element at bottom
  public static void pushAtBottom(Stack<Integer> s, int data) {
    if (s.isEmpty()) {
      s.push(data);
      return;
    }
    int top = s.pop();
    pushAtBottom(s, data);
    s.push(top);
  }

  // Reverse a stack using recursion
  public static void revStack(Stack<Integer> s) {
    if (s.isEmpty()) {
      return;
    }
    int top = s.pop();
    revStack(s);
    pushAtBottom(s, top);
  }

  // print a Stack
  public static void printStack(Stack<Integer> s) {
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    revStack(s);
    printStack(s);
  }

}
