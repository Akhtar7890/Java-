package MultiThreading;

public class Test {
  public static void main(String[] args) {

    World w = new World();// Thread class
    w.start();// start() method is used to initiate the thread

    // Creation of new thread because we are implementing the Runnable interface and
    // the pass the object of World2 class in it as contrustor because start() is
    // not present in runnable inteface and we need that method to initate the thred

    World2 world = new World2(); // Runnable interface

    // Creating new thred
    Thread t1 = new Thread(world);
    t1.start();

    for (int i = 0; i < 100; i++) {
      System.out.println("Hello");
    }
    System.out.println(Thread.currentThread().getName());// this method gives the thread name executing currently
  }
}
