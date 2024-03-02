package ArrayProgram;

public class RemoveDuplicate {
  public static int removeDuplicate(int arr[]) {
    int j = 0;
    if (arr.length == 0 || arr.length == 1) {
      return arr.length;
    }
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] != arr[i + 1]) {
        arr[j++] = arr[i];
      }
    }
    arr[j++] = arr[arr.length - 1];
    return j;
  }

  public static void main(String[] args) {
    int arr[] = { 0, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5 };
    int j = removeDuplicate(arr);
    for (int i = 0; i < j; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
