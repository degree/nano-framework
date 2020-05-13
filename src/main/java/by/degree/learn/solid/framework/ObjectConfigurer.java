package by.degree.learn.solid.framework;

public interface ObjectConfigurer {
    <T> void configure(T t, Context context);
}
