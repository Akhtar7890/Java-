package String;

public class Substring {
  public static String printSubString(String str, int start, int end) {
    StringBuilder sb = new StringBuilder("");
    for (int i = start; i < end; i++) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = new String("Akhtar Babu");
    System.out.println(printSubString(str, 2, 8));
  }
}
