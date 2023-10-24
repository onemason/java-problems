package io.github.ryan.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * thread[0]、thread[1]、thread[2]三个线程互相等待，所有线程执行到了await方法等待则结束，各自执行后续动作
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        Thread[] threads = new Thread[4];
        CyclicBarrier barrier = new CyclicBarrier(3);
        threads[0] = new Thread(() -> {
            try {
                System.out.println("step 0 started");
                TimeUnit.SECONDS.sleep(1);
                barrier.await();
                System.out.println("step 0 finished");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });

        threads[1] = new Thread(() -> {
            try {
                System.out.println("step 1 started");
                TimeUnit.SECONDS.sleep(2);
                barrier.await();
                System.out.println("step 1 finished");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });

        threads[2] = new Thread(() -> {
            try {
                System.out.println("step 2 started");
                TimeUnit.SECONDS.sleep(10);
                barrier.await();
                System.out.println("step 2 finished");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });

        threads[0].start();
        threads[1].start();
        threads[2].start();
    }

}
