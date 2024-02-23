package ArrayProgram;

public class Kadane {
  public static void kadaneMaxSubaaray(int[] arr) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      currSum += arr[i];
      if (currSum < 0) {
        currSum = 0;
      }
      maxSum = Math.max(currSum, maxSum);
    }
    System.out.println("Maximum sum : " + maxSum);
  }

  // Solved usin Kadane's Algorithm Applicable for both negative and positive
  // numbers
  public static int maxSubArray(int[] nums) {
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (currentSum >= 0) {
        currentSum = currentSum + nums[i];
      } else {
        currentSum = nums[i];
      }
      maxSum = Math.max(currentSum, maxSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = { -3, -2, -3, -2 };
    // kadaneMaxSubaaray(arr);
    System.out.println("Max subArray Sum is : " + maxSubArray(nums));
    kadaneMaxSubaaray(nums);
  }
}
