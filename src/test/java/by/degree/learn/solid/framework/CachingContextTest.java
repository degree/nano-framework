package by.degree.learn.solid.framework;

import by.degree.learn.solid.framework.test.TestSingleImplementationInterface;
import by.degree.learn.solid.framework.test.TestSingletonComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CachingContextTest {

    private static final String TEST_PACKAGE = CachingContextTest.class.getPackageName() + ".test";

    private Context context;

    @BeforeEach
    void setUp() {
        context = Application.run(TEST_PACKAGE);
    }

    @Test
    void lookupClass() {
        var firstLookup = context.getObject(TestSingletonComponent.class);
        var secondLookup = context.getObject(TestSingletonComponent.class);
        assertSame(firstLookup, secondLookup, "Objects after lookup by class must be the same");
    }

    @Test
    void lookupInterface() {
        var firstLookup = context.getObject(TestSingleImplementationInterface.class);
        var secondLookup = context.getObject(TestSingleImplementationInterface.class);
        assertSame(firstLookup, secondLookup, "Objects after lookup by interface must be the same");
    }
}
