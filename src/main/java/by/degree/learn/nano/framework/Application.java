package by.degree.learn.nano.framework;

public class Application {

    public static Context run(String basePackage) {
        Config config = new JavaConfig(basePackage);
        Context context = new CachingContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        context.setFactory(factory);
        return context;
    }
}
