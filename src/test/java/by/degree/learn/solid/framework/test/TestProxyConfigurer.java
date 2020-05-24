package by.degree.learn.solid.framework.test;

import by.degree.learn.solid.framework.Component;
import by.degree.learn.solid.framework.ProxyConfigurer;

import java.lang.reflect.Proxy;

@Component
public class TestProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object wrapIfNeeded(Object t, Class implClass) {
        if (implClass.getInterfaces().length != 0) {
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> method.invoke(t, args));
        } else {
            return t;
        }
    }
}
