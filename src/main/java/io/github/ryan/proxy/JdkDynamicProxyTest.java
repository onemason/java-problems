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
 * JDK动态代理
 * 可以为一个接口动态生成代理对象
 * 也可以为委托类动态生成代理对象，前提是这个委托类实现了接口
 */
public class JdkDynamicProxyTest {
    public static void main(String[] args) {

        ClassLoader loader = Driver.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{Driver.class};
        // 代理类会执行的方法
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) {
                if ("drive".equals(method.getName())) {
                    System.out.println("I'm a driverProxy,I'm driving at a speed of " + args[0] + "km/h");
                }
                return null;
            }
        };

        // 最终输出: I'm a driverProxy,I'm driving at a speed of 100km/h
        Driver driverProxy = (Driver) Proxy.newProxyInstance(loader, interfaces, handler);
        driverProxy.drive(100L);
    }

}

