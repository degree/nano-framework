package by.degree.learn.disinfector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AnnouncerProxy implements ProxyConfigurer {
    private static boolean hasAnnotation(Method method) {
        return method.isAnnotationPresent(Announce.class);
    }

    private static String render(Object... args) {
        return Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
    }

    @Override
    public Object wrapIfNeeded(Object t, Class implClass) {

        boolean hasMethods = Arrays.stream(implClass.getDeclaredMethods()).anyMatch(AnnouncerProxy::hasAnnotation);

        if (hasMethods) {
            if (implClass.getInterfaces().length != 0) {
                return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), buildHandler(t));
            } else {
                throw new RuntimeException("Classes are not supported: " + implClass);
            }
        } else {
            return t;
        }
    }

    private InvocationHandler buildHandler(Object t) {
        return (proxy, method, args) -> {
            var wrap = method.isAnnotationPresent(Announce.class);
            var render = wrap ? render(args) : null;
            if (wrap) {
                System.out.println("Announce disinfection: leave " + render);
            }

            var result = method.invoke(t, args);

            if (wrap) {
                System.out.println("Announce disinfection: complete " + render);
            }
            return result;
        };
    }
}
