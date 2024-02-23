package Stack;

import java.util.ArrayList;

public class Stack {

  public static class Stack2 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isEmpty() {
      return list.size() == 0;
    }

    // push
    public void push(int data) {
      list.add(data);
    }

    // pop
    public static int pop() {
      if (isEmpty()) {
        return -1;
      }
      int val = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return val;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        return -1;
      }
      int val = list.get(list.size() - 1);
      return val;
    }
  }

  public static void main(String[] args) {
    Stack2 s = new Stack2();
    s.push(1);
    s.push(2);
    s.push(3);
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }

  }
}
