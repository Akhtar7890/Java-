package Greedy;

import java.util.*;

public class MaxLengthChainPair {
  public static void main(String[] args) {
    int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
    Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));
    int chainLength = 1;
    int lastEndPair = pair[0][1];
    for (int i = 0; i < pair.length; i++) {
      if (pair[i][0] > lastEndPair) {
        chainLength++;
        lastEndPair = pair[i][1];
      }
    }
    System.out.println("Max Length chain : " + chainLength);
  }
}
