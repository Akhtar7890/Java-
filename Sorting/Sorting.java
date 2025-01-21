package TCS;

public class Sorting {

  private static void printSortedArray(int[] arr) {
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }

  /////////////////////// BUBBLE SORT ///////////////////
  // COMPLEXITY --- O(n2)
  private static void bubbleSort(int[] arr) {
    boolean swap;
    for (int i = 0; i < arr.length; i++) {
      swap = false;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swap = true;
        }
      }
      if (swap = false) {
        break;
      }
    }
    printSortedArray(arr);
  }

  ////////////////////// ISERTION SORT ///////////////////
  // COMPELXITY --- O(n2)
  private static void insertionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      // int curr = arr[i];
      // int prevIdx = i - 1;
      // while (prevIdx >= 0 && arr[prevIdx] > curr) {
      // arr[prevIdx + 1] = arr[prevIdx];
      // prevIdx--;
      // }
      // arr[prevIdx + 1] = curr;
      int j = i;
      while (j > 0 && arr[j - 1] > arr[j]) {
        int temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
        j--;
      }
    }
    printSortedArray(arr);
  }

  //////////////////////// SELECTION SORT /////////////////
  // COMPLEXITY--- O(n2)
  private static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minPos = i;
      for (int j = i + 1; j < arr.length - 1; j++) {
        if (arr[minPos] > arr[j]) {
          minPos = j;
        }
      }
      int temp = arr[minPos];
      arr[minPos] = arr[i];
      arr[i] = temp;
    }
    printSortedArray(arr);
  }

  ////////////////////// QUICK SORT ///////////////////////////////
  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];// last element is pivot
    int i = low - 1;// pivot se chote kitne element aayenge pivot

    for (int j = low; j < high; j++) {// j used for traversing of element
      if (arr[j] < pivot) {
        i++;
        // swap those elements jo khali jagah pe ... chota element hai pivot se mila hai
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    // swap with pivot
    i++;
    int temp = arr[i];
    arr[i] = pivot;
    arr[high] = temp;
    return i;/// correct postion of pivot
  }

  // COMPLEXITY
  // O(n2)-->worst
  // Average-->O(nlogn) Reason because of everytime a pivot is small element of
  // largest element(compeletly sorted hoga )
  private static void quicSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivotIdx = partition(arr, low, high);
      quicSort(arr, low, pivotIdx - 1);// left half
      quicSort(arr, pivotIdx + 1, high);// right half
    }
  }


  /////////////////////////////// MERGE SORT /////////////////////////////////////
  /// COMPLEXITY--- O(nlogn)
  /// O(logn)--> divide
  /// O(n)-->conqure
  private static void conqure(int[] arr, int si, int mid, int ei) {
    int[] merged = new int[ei - si + 1];

    int idx1 = si;// tracking the first array
    int idx2 = mid + 1;// tracking the second array
    int x = 0;// tracking the merged array

    // comparision of elements of array
    while (idx1 <= mid && idx2 <= ei) {
      if (arr[idx1] <= arr[idx2]) {
        merged[x] = arr[idx1];
        x++;
        idx1++;
      } else {
        merged[x] = arr[idx2];
        idx2++;
        x++;
      }
    }

    // bacche hue element jo already sorted hai
    while (idx1 <= mid) {
      merged[x++] = arr[idx1++];
    }
    while (idx2 <= ei) {
      merged[x++] = arr[idx2++];
    }

    for (int i = 0, j = si; i < merged.length; i++, j++) {
      arr[j] = merged[i];
    }
  }

  //O(nlogn)
  private static void divide(int[] arr, int si, int ei) {
    if (si >= ei) {
      return;
    }
    int mid = si + (ei - si) / 2;
    // this formula is most used because of space less used while coding on other
    // plateform
    // if we use (si+ei)\2 this can cause space problem which exceeds the range
    // something because we add largest and smallest value togather may cause the
    // exceed the range of integer
    divide(arr, si, mid);
    divide(arr, mid + 1, ei);
    conqure(arr, si, mid, ei);

  }

  public static void main(String[] args) {
    int[] arr = { 4, 5, 6, 3, 2, 1, 0, 9, 7, 8 };
    // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    // bubbleSort(arr);
    System.out.println();
    // insertionSort(arr);
    // selectionSort(arr);
    printSortedArray(arr);
    System.out.println();
    // quicSort(arr, 0, arr.length - 1);
    divide(arr, 0, arr.length - 1);
    printSortedArray(arr);
  }
}
