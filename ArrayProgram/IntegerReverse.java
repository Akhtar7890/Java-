package ArrayProgram;

public class IntegerReverse {
  public static int reverseInt(int x) {
    int rev = 0;
    while (x > 0) {
      int rem = x % 10;
      if (rev > (Integer.MAX_VALUE - rem) / 10) {
        return 0;
      }
      rev = (rev * 10) + rem;
      x /= 10;
    }
    return rev;
  }

  public static void main(String[] args) {
    int x = -122;
    System.out.print(reverseInt(x));
  }
}
