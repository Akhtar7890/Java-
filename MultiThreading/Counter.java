package MultiThreading;

public class Counter {
  private int count = 0;

  // using synchronozed keyword make sure that one thread is using this method
  // then other thread will wait

  // public synchronized void increament(){
  // count++;
  // }
  public void increament() {
    // synchronized block
    synchronized (this) {
      count++;
    }

  }

  public int getCount() {
    return count;
  }
}
