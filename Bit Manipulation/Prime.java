public class Prime {
  public static boolean isPrime(int n) {
    if (n == 2) {
      return true;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  // All prime numbers in range
  public static void rangeInPrime(int n) {
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }

  // Pallindrome Number
  public static void pallindromeNum(int n) {
    int num = n;
    int reverse = 0;
    while (n != 0) {
      int rem = n % 10;
      reverse = reverse * 10 + rem;
      n = n / 10;
    }
    if (num == reverse) {
      System.out.println("Pallindrome");
    } else {
      System.out.println("Not Pallindrome");
    }
  }

  public static void main(String[] args) {
    pallindromeNum(1211);
  }
}
