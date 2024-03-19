package ArrayProgram;

public class CountPrime {

  public static int count(int n) {
    boolean prime[] = new boolean[n];
    for (int i = 2; i * i < n; i++) {
      if (prime[i] == false) {
        for (int j = i * i; j < n; j = j + i) {
          prime[j] = true;
        }
      }
    }
    int count = 0;
    for (int i = 2; i < prime.length; i++) {
      if (prime[i] == false)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    int n = 10;
    int res = count(n);
    System.out.println(res);
  }
}
