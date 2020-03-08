package io.github.ryan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 抛弃委托类直接对接口产生一个代理类
 */
public class DemoInvocationHandler implements InvocationHandler {
    /*
        代理类会执行的方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("all were done.");
        return null;
    }


    /*
        test
        最终输出: all were done.
     */
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?>[] interfaces = new Class[]{DemoInterface.class};
        InvocationHandler handler = new DemoInvocationHandler();
        DemoInterface demoInterfaceProxy = (DemoInterface) Proxy.newProxyInstance(loader, interfaces, handler);
        demoInterfaceProxy.doSomething();
    }

}

