public class BinaryDecimal {
  public static void binaryToDecimal(int binNum) {
    int myNum = binNum;
    int pow = 0;
    int dec = 0;
    while (binNum > 0) {
      int lsb = binNum % 10;
      dec = dec + (lsb * (int) Math.pow(2, pow));
      pow++;
      binNum = binNum / 10;
    }
    System.out.println("Decimal of " + myNum + " = " + dec);
  }

  public static void decimalToBinary(int n) {
    int m = n;
    int pow = 0;
    int binary = 0;
    while (n > 0) {
      int rem = n % 2;
      binary = binary + (rem * (int) (Math.pow(10, pow)));
      pow++;
      n = n / 2;
    }
    System.out.println("Binary of " + m + " = " + binary);
  }

  public static void main(String[] args) {
    binaryToDecimal(111);
    decimalToBinary(7);
  }
}
