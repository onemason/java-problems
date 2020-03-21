package io.github.ryan.simple;

/**
 * @author Ryan
 * @date 2020/03/21 Sat.
 *
 * 静态代码块，构造代码块，构造器的执行时机
 */
public class BarProcess extends FooProcess {

    private String s;

    static {
        System.out.println("Bar static block executed.");
    }

    {
        System.out.println("Bar anonymous code block executed.");
    }

    public BarProcess() {
        System.out.println("Bar no-argument constructor executed.");
    }

    public BarProcess(String s) {
        super(s); // 不显示调用的话会默认调用super()
        System.out.println("Bar with-argument constructor executed.");
    }

    public static void main(String[] args) {
        new BarProcess();
        new BarProcess("");
    }

}
