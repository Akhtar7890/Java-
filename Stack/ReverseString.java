package Stack;

import java.util.Stack;

public class ReverseString {
  public static String revString(Stack<Character> ch, String str) {
    for (int i = 0; i < str.length(); i++) {
      ch.push(str.charAt(i));
    }
    StringBuilder sb = new StringBuilder("");
    while (!ch.isEmpty()) {
      sb.append(ch.pop());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Stack<Character> ch = new Stack<>();
    String str = "12345";
    System.out.println(revString(ch, str));

  }
}
