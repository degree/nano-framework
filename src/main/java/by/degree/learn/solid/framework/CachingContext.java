package by.degree.learn.solid.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachingContext extends Context {
    @SuppressWarnings("rawtypes")
    private final Map<Class, Object> CACHE = new ConcurrentHashMap<>();

    public CachingContext(Config config) {
        super(config);
    }

    @Override
    public <T> T getObject(Class<T> target) {
        if (CACHE.containsKey(target)) {
            //noinspection unchecked
            return (T) CACHE.get(target);
        }

        var object = super.getObject(target);

        if (getConfig().isSingleton(object.getClass())) {
            CACHE.put(target, object);
        }

        return object;
    }
}
