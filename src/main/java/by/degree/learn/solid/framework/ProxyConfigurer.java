package by.degree.learn.solid.framework;

public interface ProxyConfigurer {
    Object wrapIfNeeded(Object t, Class implClass);
}
