package io.github.ryan.simple;

/**
 * 自增运算
 * i = 4, j = 1 ,k = 11
 */
public class Increment {

    public void inc() {
        int i = 1, j, k;
        i = i++;
        j = i++;
        k = i + ++i * i++;
    }

}