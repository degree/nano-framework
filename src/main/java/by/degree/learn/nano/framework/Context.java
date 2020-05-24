package by.degree.learn.nano.framework;

public class Context {
    private final Config config;
    private ObjectFactory factory;

    public Context(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> target) {
        var implClass = config.lookupImplementationClass(target);
        return factory.createObject(target, implClass);
    }

    public void setFactory(ObjectFactory factory) {
        this.factory = factory;
    }

    public Config getConfig() {
        return config;
    }
}
