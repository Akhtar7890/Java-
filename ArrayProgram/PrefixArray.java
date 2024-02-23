package ArrayProgram;

public class PrefixArray {
  public static void prefixSubarrayMax(int[] arr) {
    int n = arr.length;
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int[] prefix = new int[n];
    prefix[0] = arr[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + arr[i];
    }

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
        if (currSum > maxSum) {
          maxSum = currSum;
        }
      }
    }
    System.out.println("Maximum sum : " + maxSum);
  }

  public static void main(String[] args) {
    int[] arr = { 1, -2, 6, -1, 3 };
    prefixSubarrayMax(arr);
  }

}
