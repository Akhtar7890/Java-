package MultiThreading;

public class Test2 {
  public static void main(String[] args) {
    Counter counter = new Counter();

    // ek hi counter object ko two different threads ko pass krr rhe hai
    NewThread t1 = new NewThread(counter);
    NewThread t2 = new NewThread(counter);
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (Exception e) {

    }
    System.out.println(counter.getCount());
  }
}
