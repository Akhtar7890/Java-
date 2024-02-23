package Stack;

import java.util.Stack;

public class DupParenthesis {
  public static boolean duplicateParenthesis(String str) { // O(n)
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == ')') {
        int count = 0;
        while (s.pop() != '(') {
          count++;
        }
        if (count < 1) {// Duplicate
          return true;
        }
      } else {
        s.push(ch);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // valid pallindrome
    String str = "(a+b)";
    System.out.println(duplicateParenthesis(str));
  }
}
