package by.degree.learn.nano.framework;

public interface ObjectConfigurer {
    <T> void configure(T t, Context context);
}
