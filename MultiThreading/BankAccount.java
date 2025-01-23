package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private int balance = 100;

  // problem with synchronized keyword is it lock the resource util it completes
  // its execution and other threads wait till it complete it exection this is the
  // problem so to avoid this we use the "Explicit Lock"
  // public synchronized void withdraw(int amount) {
  // System.out.println(Thread.currentThread().getName() + " attempting to
  // withdraw " + amount);
  // if (balance >= amount) {
  // System.out.println(Thread.currentThread().getName() + " proceeding with
  // withdrawal");
  // try {
  // Thread.sleep(3000);
  // } catch (InterruptedException e) {

  // }
  // balance -= amount;
  // System.out.println(Thread.currentThread().getName() + " completed withrwal.
  // Remaining balance is : " + amount);
  // } else {
  // System.out.println(Thread.currentThread().getName() + " insufficient
  // balance");
  // }
  // }

  /// Explixit lock
  Lock lock = new ReentrantLock();

  public void withdraw(int amount) {
    System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

    try {
      if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
        if (balance >= amount) {
          try {
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
            Thread.sleep(3000);
            balance -= amount;
            System.out
                .println(Thread.currentThread().getName() + " completed withrwal. Remaining balance is : " + amount);
          } catch (Exception e) {
            Thread.currentThread().interrupt();
          } finally {
            lock.unlock();
          }
        } else {
          System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
      } else {
        System.out.println(Thread.currentThread().getName() + " could not accquire the lock , will try again later");
      }
    } catch (Exception e) {
      Thread.currentThread().interrupt();
    }
    if (Thread.currentThread().isInterrupted()) {
      System.out.println(" kuch maintenace");
    }
  }
}
