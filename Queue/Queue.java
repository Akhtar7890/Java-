package Queue;

//linear queue using array
public class Queue {
  static class Que {
    static int arr[];
    static int size;
    static int rear;

    Que(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
    }

    public static boolean isEmpty() {
      return rear == -1;
    }

    // Add in a queue
    public static void add(int data) { // O(1)
      if (rear == size - 1) {
        System.out.println("Queue is full");
        return;
      }
      rear = rear + 1;
      arr[rear] = data;
    }

    // Delete in a queue
    public static int removeFront() { // O(n)
      if (isEmpty()) {
        System.out.print("Empty queue ");
        return -1;
      }
      int del = arr[0];
      for (int i = 0; i < rear; i++) {
        arr[i] = arr[i + 1];
      }
      rear = rear - 1;
      return del;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        System.out.print("Queue is empty ");
        return -1;
      }
      return arr[0];
    }
  }

  public static void main(String[] args) {
    Que q = new Que(5);
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(4);
    q.add(4);
    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.removeFront();

    }
  }
}
