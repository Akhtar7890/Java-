public class Bitwise {
  public static void main(String[] args) {
    System.out.println(10 & 11);// Perform AND operation
    System.out.println(5 ^ 4);// Same bit--> 0 Differnts bits--> 1
    System.out.println(~5);// One's complement + 1
    System.out.println(~0); // Output will be (-1)base 10
    System.out.println(5 << 2);// left Shift(Shift the value by 2 place (Formula--> a<<b=a*2^b))
    System.out.println(6 >> 1);// Right Shift(Formula--> a>>b=a/2^b)
  }
}
