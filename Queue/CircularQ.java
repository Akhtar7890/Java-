package Queue;

public class CircularQ {
  static class CircularQueue {
    static int arr[];
    static int size;
    static int rear;
    static int front;

    CircularQueue(int n) {
      arr = new int[n];
      size = n;
      front = -1;
      rear = -1;
    }

    public static boolean isEmpty() {
      return front == -1 && rear == -1;
    }

    public static boolean isFull() {
      return (rear + 1) % size == front;
    }

    public static void add(int data) {
      if (isFull()) {
        System.out.println("Queue is full");
        return;
      } // add 1st element
      if (front == -1) {
        front = 0;
      }
      rear = (rear + 1) % size;
      arr[rear] = data;
    }

    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      int result = arr[front];
      if (front == rear) {
        front = rear = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
      }
      return arr[front];
    }
  }

  public static void main(String[] args) {
    CircularQueue c = new CircularQueue(3);
    c.add(1);
    c.add(2);
    c.add(3);
    System.out.println(c.remove());
    c.add(4);
    System.out.println(c.remove());
    c.add(5);
    while (!c.isEmpty()) {
      System.out.println(c.peek());
      c.remove();
    }
  }
}
