package io.github.ryan.simple;

public class FooLoadClassProcess {

    private String s;

    static {
        System.out.println("Foo static block executed.");
    }

    {
        System.out.println("Foo anonymous code block executed.");
    }

    public FooLoadClassProcess() {
        System.out.println("Foo no-argument constructor executed.");
    }

    public FooLoadClassProcess(String s) {
        this.s = s;
        System.out.println("Foo with-argument constructor executed.");
    }

}
