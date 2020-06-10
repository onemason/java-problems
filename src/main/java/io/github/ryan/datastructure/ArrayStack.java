package io.github.ryan.datastructure;

import lombok.ToString;

/**
 * 基于数组实现的简易栈
 *
 * TODO 实现栈的自动扩容
 */
@ToString
public class ArrayStack {

    private String items[];
    private int count;
    private int n;

    /**
     * 初始化空间为n的数组
     * @param n
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        String tmp = items[count - 1];
        --count;
        return tmp;
    }

}
