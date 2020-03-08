package io.github.ryan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Ryan
 * @date 2020/03/08 Sun.
 *
 * @description 为接口生成代理对象
 *
 * JDK动态代理，可以为一个接口动态生成代理对象
 * 也可以为一个委托类动态生成代理对象，前提是这个类实现了接口
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

