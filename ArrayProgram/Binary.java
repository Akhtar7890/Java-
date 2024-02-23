package ArrayProgram;

public class Binary {
  public static int recursionBinarySearch(int arr[], int target, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] < target) {
        return binarySearch(arr, target, mid + 1, end);
      } else {
        return binarySearch(arr, target, start, mid - 1);
      }
    }
    return -1;
  }

  // Brute force Method of binary search
  public static int binarySearch(int arr[], int target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] < target) {
        start = mid + 1;
      } else if (arr[mid] > target) {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { -1, 0, 3, 5, 9, 12 };
    System.out.println(binarySearch(arr, 2, 0, arr.length));
    // System.out.println("Element found at index : " + recursionBinarySearch(arr,
    // 2, 0, arr.length));
  }
}
