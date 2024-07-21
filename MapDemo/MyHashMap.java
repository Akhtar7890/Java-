package MapDemo;

import java.util.Arrays;;

public class MyHashMap {
  int[] map;

  public MyHashMap() {
    map = new int[1000001];
    Arrays.fill(map, -1);
  }

  // put method
  public void put(int key, int value) {
    map[key] = value;
  }

  /// get method
  public int get(int key) {
    return map[key];
  }
  // remove method

  public void remove(int key) {
    map[key] = -1;
  }

  public static void main(String[] args) {
    MyHashMap m = new MyHashMap();
    m.put(1, 2);
    m.put(2, 2);
    System.out.println(m.get(1));
    System.out.println(m.get(3));
    m.put(2, 1);
    System.out.println(m.get(2));

  }
}
