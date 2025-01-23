package MultiThreading;

public class World extends Thread {

  // override the run method
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("World");
    }
    System.out.println(Thread.currentThread().getName());
  }
}
