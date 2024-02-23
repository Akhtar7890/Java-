package ArrayProgram;

public class Bubble {
  public static void bubbleSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j + 1] < arr[j]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
        // for (int k = 0; k < arr.length; k++) {
        // System.out.print(arr[k] + " ");
        // }
        // System.out.println();
      }
    }
    System.out.print("Sorted array : ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void main(String[] args) {
    int[] arr = { 2, 5, 1, 8, 7, 0, 4 };
    bubbleSort(arr);
  }
}
