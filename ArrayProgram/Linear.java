package ArrayProgram;

import java.util.ArrayList;

public class Linear {
  // Linear search from starting index -->Recurrsion
  public static int linearSearch(int arr[], int target, int index) {
    if (index == arr.length) {
      return -1;
    }
    if (arr[index] == target) {
      return index;
    } else {
      return linearSearch(arr, target, index + 1);
    }
  }

  // Linear Search of all occurence of element
  static ArrayList<Integer> list = new ArrayList<>();

  public static void linearSearchAllOccurence(int arr[], int target, int index) {
    if (index == arr.length) {
      return;
    }
    if (arr[index] == target) {
      list.add(index);
    }
    linearSearchAllOccurence(arr, target, index + 1);
  }

  // Linear search from last occurence of element
  public static int linearSearchLastOccurence(int arr[], int target, int index) {
    if (index == -1) {
      return -1;
    }
    if (arr[index] == target) {
      return index;
    } else {
      return linearSearchLastOccurence(arr, target, index - 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 4, 6, 2, 1, 9, 7, 0, 1, 9, 3 };
    System.out.println("Element found at index : " + linearSearch(arr, 9, 0));
    linearSearchAllOccurence(arr, 9, 0);
    System.out.println("Element present at index : " + list);
    System.out.println("Element found at index : " + linearSearchLastOccurence(arr, 9, arr.length - 1));

  }
}
