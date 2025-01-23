package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

  Lock lock = new ReentrantLock();

  // bsaically it maintains the counter variable on shared resource so that to
  // avoid another thread to get access to that resource utill it is fully
  // unlocked

  // No deadlock occur here
  public void outerMethod() {
    lock.lock();
    try {
      System.out.println("Outer method executed");
      innerMethod();
    } finally {
      lock.unlock();
    }
  }

  public void innerMethod() {
    lock.lock();
    try {
      System.out.println("Inner method");
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    ReentrantExample exp = new ReentrantExample();
    exp.outerMethod();
  }
}
