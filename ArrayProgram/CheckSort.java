package ArrayProgram;

public class CheckSort {
  // checking from starting index
  static boolean sortCheck(int[] arr, int index) {
    if (index == arr.length - 1) {
      return true;
    }
    return arr[index] < arr[index + 1] && sortCheck(arr, index + 1);
  }

  // Checking from last index
  static boolean checkSortLast(int[] arr, int index) {
    if (index == -1) {
      return true;
    }
    return arr[index] < arr[index + 1] && checkSortLast(arr, index - 1);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    System.out.println(sortCheck(arr, 0));
    System.out.println(checkSortLast(arr, arr.length - 1));
  }
}