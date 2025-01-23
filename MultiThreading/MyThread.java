package MultiThreading;

public class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println("RUNNING");
    // for (int i = 0; i < 5; i++) {
    // System.out.println(Thread.currentThread().getName() + " is running");
    // Thread.yield();// gives the chance to other thread
    // }

    while (true) {
      System.out.println("JAVA");
    }
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // super.run();
  }

  public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread("t1");// NEW
    MyThread t2 = new MyThread("t2");
    t1.setDaemon(true);
    // System.out.println(t1.getState());
    t1.start();// RUNNABLE
    System.out.println("Main done");
    // t2.start();
    // System.out.println(t1.getState());
    // System.out.println(Thread.currentThread().getState());
    // System.out.println(Thread.currentThread().getName());
    // Thread.sleep(100);// main method is sleep for 1 sec
    // System.out.println(t1.getState());
    // t1.join(); // TIMED_WAITING main method /thread will wait to t1 get finished
    // System.out.println(t1.getState()); // TERMINATED
    // System.out.println(Thread.currentThread().getName());
  }

  // Methods of thread
  // t1.start(), run() ,t1.sleep() t1.join() t1.setPriority(),Thread.yiel(),
  // t1.setDemon()
  // User Thread- jo kaam hum kara rhe hai jis thread ki help se usse userthread
  // kahte hai
  // Demo Thread- jo background mein chalte hai jaise GarbageCollector() JVM will
  // not wait for jaise hi main method execute khatam ho jata hai turant hi demon
  // thread apna kaam khatam krr deta ai
}
