import java.util.*;

public class Solution {
  static void printFibonacci(int k) {
    int first = 0, second = 1, sum = 0;
    System.out.print(first + " " + second + " ");
    for (int i = 0; i < k; i++) {
      sum = first + second;
      System.out.print(sum + " ");
      first = second;
      second = sum;
    }
  }

  static void printPattern(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = i; k < n; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    // second half
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = i; k <= n; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

  static void findDuplicate(int arr[]) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      if (set.contains(arr[i])) {
        System.out.print(arr[i] + " ");
      } else {
        set.add(arr[i]);
      }
    }
  }

  public static void main(String[] args) {
    // printFibonacci(6);
    // System.out.println();
    // int[] arr = { 2, 3, 4, 2, 4, 5, 5, 6 };
    // findDuplicate(arr);
    // System.out.println();
    printPattern(9);

  }
}
