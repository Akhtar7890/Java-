
public class Even_odd {
  static void oddOrEven(int num) {
    int bitMask = 1;
    if ((num & bitMask) == 0) {
      System.out.println(" Even Number");
    } else {
      System.out.println("Odd Number");
    }
  }

  public static void main(String[] args) {
    oddOrEven('a');
    oddOrEven(6);
  }
}
