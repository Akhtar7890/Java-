// import java.util.*;

public class Pattern {
  public static void halfPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  public static void charPattern(int n) {
    char ch = 'A';
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(ch + " ");
        ch++;
      }
      System.out.println();
    }
  }

  public static void rightHalfPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int k = n; k > i; k--) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    rightHalfPyramid(4);
  }
}
