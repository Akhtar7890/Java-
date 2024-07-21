import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.Arrays;
//import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class RotateArray {
  private static void reverse(int[] arr, int si, int ei) {
    while (si < ei) {
      int temp = arr[si];
      arr[si] = arr[ei];
      arr[ei] = temp;
      si++;
      ei--;
    }
  }

  static void rotateArray(int[] arr, int k) {
    int n = arr.length;
    k = k % n;
    reverse(arr, 0, n - k - 1);
    reverse(arr, n - k, n - 1);
    reverse(arr, 0, n - 1);
  }

  static int reverseInteger(int n) {
    int m = Math.abs(n);
    int rev = 0;
    while (m != 0) {
      int lsb = m % 10;
      rev = rev * 10 + lsb;
      m = m / 10;
    }
    return (n < 0) ? (-rev) : rev;
  }

  static void storeWeeklyTestScore() {
    int[][] week = new int[2][];
    week[0] = new int[2];
    week[1] = new int[4];
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter weekly score : ");
    for (int i = 0; i < week[0].length; i++) {
      week[0][i] = sc.nextInt();
    }
    for (int i = 0; i < week[1].length; i++) {
      week[1][i] = sc.nextInt();
    }
    System.out.println("Weekly score marks are : ");
    for (int[] sore : week) {
      System.out.print(sore[0] + " ");
    }
    for (int[] sore : week) {
      System.out.print(sore[0] + " ");
    }
  }

  static int findIndex(int[] arr, int value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        return i;
      }
    }
    return -1;
  }

  static void delete(int[] arr, int index) {
    int k = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i == index) {
        continue;
      } else {
        arr[k++] = arr[i];
      }
    }
    for (int i = 0; i < arr.length - 1; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  static void findMinMax(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int minIndex = 0, maxIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
        minIndex = i;
      }
      if (arr[i] > max) {
        max = arr[i];
        maxIndex = i;
      }
    }
    System.out.println(min + " " + max);
    int k = 0, i = 0;
    int[] arr2 = new int[arr.length + 2];
    while (i < arr.length) {
      if (i == minIndex) {
        arr2[k++] = min;
      }
      if (i == maxIndex) {
        arr2[k++] = max;
      }
      arr2[k++] = arr[i];
      i++;
    }
    for (i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
  }

  static void calculateAvg(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    double avg = sum / arr.length;
    System.out.println("average : " + avg);
  }

  static void sortArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  static void sortStringArray(String[] str) {
    // Arrays.sort(str);
    for (int i = 0; i < str.length - 1; i++) {
      for (int j = i + 1; j < str.length; j++) {
        if (str[i].compareTo(str[j]) > 0) {
          String temp = str[i];
          str[i] = str[j];
          str[j] = temp;
        }
      }
    }
    for (int i = 0; i < str.length; i++) {
      System.out.print(str[i] + " ");
    }
  }

  static void findDuplcates(String str1, String str2) {
    Set<Character> set1 = new HashSet<>();
    Set<Character> set2 = new HashSet<>();
    List<Character> list1 = new ArrayList<>();
    List<Character> list2 = new ArrayList<>();
    for (char c : str1.toCharArray()) {
      if (set1.contains(c)) {
        list1.add(c);
      } else {
        set1.add(c);
      }
    }
    System.out.println(list1);
    for (char ch : str2.toCharArray()) {
      if (set2.contains(ch)) {
        list2.add(ch);
      } else {
        set2.add(ch);
      }
    }
    System.out.println(list2);
    System.out.print("Common duplicate character : ");
    for (char c : list1) {
      if (list2.contains(c)) {
        System.out.print(c);
      }
    }
  }

  static void maxSum(int[] arr) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (currSum >= 0) {
        currSum += arr[i];
      } else {
        currSum = arr[i];
      }
      maxSum = Math.max(currSum, maxSum);
    }
    System.out.println(maxSum);
  }

  static void printSubArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int k = i; k <= j; k++) {
          list.add(arr[k]);
        }
        System.out.print(list);
        for (int l = 0; l < list.size(); l++) {
          sum += list.get(l);
        }
        System.out.print(" " + "Sum :" + sum);
        System.out.println();
      }
    }
  }

  static void longestSubstringWithoutRepeatingCharacter(String str) {
    int maxL = 0, left = 0;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      if (!set.contains(str.charAt(i))) {
        set.add(str.charAt(i));
        maxL = Math.max(maxL, i - left + 1);
      } else {
        while (set.contains(str.charAt(i))) {
          set.remove(str.charAt(left));
          left++;
        }
        set.add(str.charAt(i));
      }
    }
    System.out.println(maxL);
  }

  static void reverseWord(String str) {
    String[] string = str.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = string.length - 1; i >= 0; i--) {
      sb.append(string[i]);
      sb.append(" ");
    }
    System.out.println(sb.toString().trim());
  }

  static void moveAllZeros(int[] num) {
    int si = 0, ei = num.length - 1, ci = 0;
    while (si < ei) {
      if (num[si] != 0) {
        si++;
        ci++;
      } else {
        si++;
        if (num[si] != 0) {
          int temp = num[ci];
          num[ci] = num[si];
          num[si] = temp;
          ci++;
        }
      }
    }
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  static boolean isPallindrome(String string) {
    int si = 0, ei = string.length() - 1;
    while (si < ei) {
      if (string.charAt(si) != string.charAt(ei)) {
        return false;
      }
      si++;
      ei--;
    }
    return true;
  }

  static void longestPallindromicSubstring(String str) {
    int maxLen = Integer.MIN_VALUE;
    String pallindrome = " ";
    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length(); j++) {
        String sub = str.substring(i, j + 1);
        if (isPallindrome(sub)) {
          int sublen = sub.length();
          if (sublen >= maxLen) {
            maxLen = sublen;
            pallindrome = sub;
          }
        }
      }
    }
    System.out.println(pallindrome);
  }

  static void countChararcter(String str) {
    Map<Character, Integer> m = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (m.containsKey(str.charAt(i))) {
        m.put(str.charAt(i), m.getOrDefault(str.charAt(i), 0) + 1);
      } else {
        m.put(str.charAt(i), 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : m.entrySet()) {
      if (entry.getValue() < 2) {
        System.out.println(entry.getKey() + " ");
      }
      // System.out.print(entry.getKey() + "->");
      // System.out.println(entry.getValue());
    }
    System.out.println(m);
  }

  static void mergeInterval() {
    int[][] interval = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    List<List<Integer>> list2 = new ArrayList<>();
    for (int i = 0; i < interval.length; i++) {
      List<Integer> list = new ArrayList<>();

    }
  }

  static int maximumSubbraySumOfSizeK(int[] arr, int k) {
    int n = arr.length;
    if (n < k) {
      return -1; // no subbarray will be found
    }
    int maxSum = 0;
    for (int i = 0; i + k <= n; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += arr[j];
      }
      if (sum > maxSum) {
        maxSum = sum;
      }
    }
    return maxSum;
  }

  public static int diagonalSum(int[][] mat) {
    int sum = 0, j = mat.length - 1;
    for (int i = 0; i < mat.length; i++) {
      // add primary diagonal elements
      sum += mat[i][i];
      // add Secondary diagonal by checking
      if (i + j == mat.length - 1) {
        sum += mat[i][j];
        j--;
      }
    }
    return sum;
  }

  static int diagonalSumOfMatrix(int[][] mat) {
    int sum = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        // Primary diagonal
        if (i == j) {
          sum += mat[i][j];
        }
        // Secondary diagonal
        if (i + j == mat.length - 1) {
          sum += mat[i][j];
        }
      }
    }
    return sum;
  }

  static int minimumStepsToOne(int n) {
    if (n == 1) {
      return 0;
    }
    int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
    if (n % 2 == 0) {
      a = 1 + minimumStepsToOne(n / 2);
    }
    if (n % 3 == 0) {
      b = 1 + minimumStepsToOne(n / 3);
    }
    c = 1 + minimumStepsToOne(n - 1);
    return Math.min(a, (Math.min(b, c)));
  }

  static int countOfUniqueSubarrayOfk(int[] arr, int k) {
    int n = arr.length;
    if (k > n) {
      return -1;
    }
    int count = 0;
    for (int i = 0; i + k <= n; i++) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    // int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    // maxSum(arr);
    // printSubArray(arr);
    // int[] arr = { 9, 8, 1, 2, 3, 4, 5, 6, 7 };
    // int value = 5;
    // int k = 3;
    // rotateArray(arr, k);
    // for (int i = 0; i < arr.length; i++) {
    // System.out.print(arr[i] + " ");
    // }
    // System.out.println();
    // int num = -1200;
    // System.out.println(reverseInteger(num));
    // storeWeeklyTestScore();
    // int index = findIndex(arr, value);
    // System.out.println("Found element at index : " + index);
    // delete(arr, index);
    // findMinMax(arr);
    // System.out.println();
    // calculateAvg(arr);
    // sortArray(arr);
    // String str1 = "Hello java";
    // String str2 = "Hee Pava";
    // findDuplcates(str1, str2);
    // String[] str = { "Ramesh", "Rama", "Kaushal", "Ajay", "Bam Bahadur" };
    // sortStringArray(str);

    // String str = "abcabcabb";
    // longestSubstringWithoutRepeatingCharacter(str);
    // String str = "My name is Akhtar Babu";
    // reverseWord(str);

    // System.out.println();
    // int[] num = { 0, 1, 0, 3, 12 };
    // int[] num = { 2, 1, 3, 4, 0, 0 };
    // moveAllZeros(num);
    // System.out.println();
    // String string = "babad";
    // longestPallindromicSubstring(string);
    // java.util.Set<Integer> set=new HashSet<>();
    // java.lang.System.println("Hello");
    // String str = "Hello";
    // countChararcter(str);

    int[] arr = { 1, 2, 3, 4, 5 };
    int k = 3;
    // System.out.println(maximumSubbraySumOfSizeK(arr, k));
    // int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // int[][] mat = { { 4, 2 } };
    // System.out.println(diagonalSum(mat));
    // System.out.println(diagonalSumOfMatrix(mat));
    System.out.println(minimumStepsToOne(10));
    System.out.println(countOfUniqueSubarrayOfk(arr, k));

  }
}
