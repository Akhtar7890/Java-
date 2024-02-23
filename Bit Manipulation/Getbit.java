public class Getbit {
  // Get bit logic
  public static int getBit(int n, int i) {
    int bitMask = 1 << i;
    if ((n & bitMask) == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  // Set bit logic
  public static int setBit(int num, int j) {
    int bitMask = 1 << j;
    return num | bitMask;
  }

  // Clear bit
  public static int clearBit(int n, int i) {
    int bitMask = ~(1 << i);
    return n & bitMask;
  }

  // Update bit logic
  public static int updateBit(int n, int i, int newBit) {
    n = clearBit(n, i);
    int bitMask = newBit << i;
    return n | bitMask;
  }

  // Clear last two bits
  public static int clearLastTwoBits(int n, int i) {
    int bitMask = (~0) << i;
    return n & bitMask;
  }

  // Clear range of bits range (i=2 to j=7 n=100111010011)
  public static int clearRangeOfBits(int n, int i, int j) {
    int a = (~0) << (j + 1);
    int b = (1 << i) - 1;
    int bitMask = a | b;
    return n & bitMask;
  }

  // Check is a number is power of 2
  public static boolean isPowerOfTwo(int n) {
    return (n & (n - 1)) == 0;
  }

  // Check count setbits in a number
  public static int countSetBit(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) != 0) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  // Calculate the power of a number using a fast exponentiation
  public static double expoPower(double a, int n) {
    double ans = 1;
    if (n < 0) {
      n = -n;
      a = 1 / a;
    }
    while (n > 0) {
      if ((n & 1) != 0) {
        ans = ans * a;
      }
      a = a * a;
      n >>= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    // System.out.println(getBit(10, 1));// ||
    // System.out.println(setBit(10, 2));
    // System.out.println(clearBit(10, 1));
    // System.out.println(updateBit(10, 2, 1));
    // System.out.println(clearLastTwoBits(15, 1));
    // System.out.println(clearRangeOfBits(10, 2, 4));
    // System.out.println(isPowerOfTwo(14));
    System.out.println(expoPower(2.00000, -2));
  }
}
