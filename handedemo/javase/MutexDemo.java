package handedemo.javase;

import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexDemo {
    Lock mutex = new ReentrantLock();
    int i = 1;

    void foo() {
        mutex.lock();
        try {
            System.out.print(i + " -> ");
            i++;
            System.out.println(i);
        } catch (Exception e) {
            //TODO: handle exception
        } finally {
            mutex.unlock();
        }
        
    }

    public static void main(final String[] args) throws InterruptedException {
        MutexDemo demo = new MutexDemo();
        Vector<Thread> pool = new Vector<>(20);
        for (int i = 0; i < pool.capacity(); i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5; j++)
                    demo.foo();
            });
            pool.add(thread);
            thread.start();
        }
        for (Thread thread : pool)
            thread.join();
        System.out.println("abc");
    }
}
