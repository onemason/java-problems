package io.github.ryan.algo.easy;

public class BubbleSort {
    /**
     * 冒泡排序
     * @param a 需要排序的数组
     */
    public void bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        // 外层循环用来控制趟数
        for (int i = 0; i < n; i++) {
            // 如果一趟中里层循环没有了需要冒泡的数说明已排序完成
            boolean swapped = false;
            // 里层循环用来冒泡
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

}
