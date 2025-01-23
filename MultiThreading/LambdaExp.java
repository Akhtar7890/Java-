package MultiThreading;

public class LambdaExp {

  public static void main(String[] args) {
    // Runnable interface ki class implementation using lambda expression
    Runnable runnable = () -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Hello");
      }
    };

    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    System.out.println(Thread.currentThread().getName() + " is slepping for 10 sec");
    try {
      t1.sleep(10000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    t2.start();

    // modern way of creating thread
    // lambda expression can we put to refernce of Runnable interface
    Thread t3 = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Hello Java");
      }
    });

    t3.start();

  }
}
