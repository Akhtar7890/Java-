package MapDemo;

import java.util.Scanner;

public class StringToInt {
  public static int secondLargest() {
    int arr[] = { 1, 6, 0, 3, 4, 8, 7 };
    int largest, secondLarge;
    largest = secondLarge = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (largest < arr[i]) {
        secondLarge = largest;
        largest = arr[i];
      } else if (secondLarge < arr[i] && arr[i] != largest) {
        secondLarge = arr[i];
      }
    }
    return secondLarge;
  }

  public static void main(String[] args) {
    System.out.println(secondLargest());
  }

  public static void main2(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int minIdx = 0, maxIdx = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxIdx = i;
      }
      if (arr[i] < min) {
        min = arr[i];
        minIdx = i;
      }
    }
    System.out.println("Min Value : " + min);
    System.out.println("Min Index : " + minIdx);
    System.out.println("Max Value : " + max);
    System.out.println("Max Index : " + maxIdx);
    System.out.println("Result : " + (maxIdx - minIdx));
  }
}
