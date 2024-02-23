package String;

public class PallindromeStr {
  public static boolean pallindromeString(String str) {
    int n = str.length();

    for (int i = 0; i < n / 2; i++) {
      if (str.charAt(i) != str.charAt(n - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String str = "noon";
    System.out.println(pallindromeString(str));
  }
}
