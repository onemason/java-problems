package io.github.ryan.simple;

/**
 * count最后的值基本不为0
 * volatile修饰的变量，只保证可见性不保证互斥性
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread st = new SubtractThread();
        st.start();

        for (int i = 0; i < NUMBER; i++) {
            count++;
        }

        // 等待做减法的线程执行结束
        while (st.isAlive()) {}
        System.out.println("count=" + count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER ; i++) {
                count--;
            }
        }
    }

}
