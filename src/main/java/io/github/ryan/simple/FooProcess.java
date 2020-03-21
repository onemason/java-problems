package io.github.ryan.simple;

public class FooProcess {

    private String s;

    static {
        System.out.println("Foo static block executed.");
    }

    {
        System.out.println("Foo anonymous code block executed.");
    }

    public FooProcess() {
        System.out.println("Foo no-argument constructor executed.");
    }

    public FooProcess(String s) {
        this.s = s;
        System.out.println("Foo with-argument constructor executed.");
    }

}
