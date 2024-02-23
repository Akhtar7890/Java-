public class Allpair {
  public static void allPairArray(int arr[]) {
    int tp = 0;
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        System.out.print("(" + curr + "," + arr[j] + ")");
        tp++;
      }
      System.out.println();
    }
    System.out.println("Total Possible pair : " + tp);// n(n-1)/2
  }

  // Compexity O(n^3)
  public static void subArrayMax(int arr[]) {
    int sumMax = Integer.MIN_VALUE; // minus infinity
    int currSum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        currSum = 0;
        for (int k = i; k <= j; k++) {
          currSum += arr[k];
        }
        if (sumMax < currSum) {
          sumMax = currSum;
        }
      }
    }
    System.out.println("Maximum subArray Sum : " + sumMax);
  }

  // complexity O(n^2)
  public static void subArray(int arr[]) {
    int tp = 0;
    System.out.println("subArrays are : ");
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + " ");
        }
        tp++;
        System.out.println();
      }
      System.out.println();
    }
    System.out.println("Total subArrays are : " + tp);// n(n+1)/2
  }

  // Complexity O(n^2)
  public static void maxSubArraySum(int arr[]) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int prefix[] = new int[arr.length];
    prefix[0] = arr[0];
    // Calculate prefix
    for (int i = 1; i < prefix.length; i++) {
      prefix[i] = prefix[i - 1] + arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
        if (maxSum < currSum) {
          maxSum = currSum;
        }
      }
    }
    System.out.println("Maximum sum : " + maxSum);
  }

  public static void main(String[] args) {
    int[] arr = { 2, -4, 6, 8, -10 };
    // allPairArray(arr);
    // subArray(arr);
    // subArrayMax(arr);
    maxSubArraySum(arr);
  }
}
