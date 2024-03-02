package Greedy;

import java.util.Arrays;

public class MinAbsoluteDiff {
  public static void main(String[] args) {
    int A[] = { 1, 4, 7, 8 };
    int B[] = { 2, 3, 5, 6 };
    Arrays.sort(A);
    Arrays.sort(B);
    int minDifference = 0;
    for (int i = 0; i < A.length; i++) {
      minDifference += Math.abs(A[i] - B[i]);
    }
    System.out.println("Absolute minDifference : " + minDifference);
  }
}
