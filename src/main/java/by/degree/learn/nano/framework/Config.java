package by.degree.learn.nano.framework;

import java.util.Collection;

public interface Config {
    <T> boolean isComponent(Class<? extends T> c);

    <T> boolean isSingleton(Class<? extends T> c);

    <T> Class<? extends T> lookupImplementationClass(Class<T> target);

    <T> Collection<Class<? extends T>> listImplementations(Class<T> type);
}
