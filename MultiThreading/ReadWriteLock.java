package MultiThreading;

import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

  private int count = 0;
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private final Lock readLock = lock.readLock();
  private final Lock writeLock = lock.writeLock();

  public void increment() {
    writeLock.lock();
    try {
      count++;
      Thread.sleep(50);
    } catch (InterruptedException e) {
      throw new RuntimeException();
    } finally {
      writeLock.unlock();
    }
  }

  public int getCount() {
    // mutiple threads ca acquire this read lock
    readLock.lock();
    try {
      return count;
    } finally {
      readLock.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ReadWriteLock counter = new ReadWriteLock();
    Runnable readTask = () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
      }
    };

    Runnable writeTask = () -> {
      for (int i = 0; i < 10; i++) {
        counter.increment();
        System.out.println(Thread.currentThread().getName() + " increamented");
      }
    };

    Thread writerThread = new Thread(writeTask);
    Thread readerThread1 = new Thread(readTask);
    Thread readerThread2 = new Thread(readTask);

    writerThread.start();
    readerThread1.start();
    readerThread2.start();

    writerThread.join();
    readerThread1.join();
    readerThread2.join();

    System.out.println("Final Count : " + counter.getCount());
  }
}
