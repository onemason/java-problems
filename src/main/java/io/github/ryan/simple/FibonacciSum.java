package io.github.ryan.simple;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @description 使用Fork/Join来计算斐波那契数列的和
 */
public class FibonacciSum {
    public static void main(String[] args) {
        // 创建分治任务线程池
        ForkJoinPool fjp = new ForkJoinPool(4);
        // 创建分治任务
        Fibonacci fib = new Fibonacci(30);
        // 启动分治任务
        Integer result = (Integer) fjp.invoke(fib);
        // 输出结果
        System.out.println(result);
    }

    // 递归任务
    static class Fibonacci extends RecursiveTask {
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        protected Integer compute() {
            if (n <= 1) return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            // 创建子任务
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            // 等待子任务结果，并合并结果
            return f2.compute() + (Integer) f1.join();
        }
    }

}
