package io.github.ryan.algorithm;

public class KMPSolution {

    /**
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 获取next数组
     *
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    private static int[] getNexts(char[] b, int m) {
        int next[] = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 0; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'g', 'q', 'a', 'd', 'q', 'b', 'd', 'q', 'a', 'd', 'd', 'q', 'a', 'd', 'd'};
        char[] b = new char[]{'a', 'd', 'q', 'a'};
        System.out.println(KMPSolution.kmp(a, a.length, b, b.length));
    }

}
