package by.degree.learn.nano.framework;

public interface ProxyConfigurer {
    Object wrapIfNeeded(Object t, Class implClass);
}
