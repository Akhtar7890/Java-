package String;

//Given  a route containing four directions (E,W,N,S) .Find the shortest path to reach destination "WNEENESENNN" 
public class ShortestPath {
  public static float getShortestPath(String str) {
    int x = 0, y = 0;
    for (int i = 0; i < str.length(); i++) {
      char direction = str.charAt(i);
      if (direction == 'N') {
        y++;
      } else if (direction == 'S') {
        y--;
      } else if (direction == 'E') {
        x--;
      } else {
        x++;
      }
    }
    int X = x * x;
    int Y = y * y;
    return (float) Math.sqrt(X + Y);
  }

  public static void main(String[] args) {
    String str = new String("WNEENESENNN");
    System.out.println(getShortestPath(str));
  }
}
