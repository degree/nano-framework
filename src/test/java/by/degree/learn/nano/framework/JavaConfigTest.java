package by.degree.learn.nano.framework;

import by.degree.learn.nano.framework.test.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaConfigTest {

    JavaConfig config = new JavaConfig("by.degree.learn.nano.framework.test");

    @Test
    void noComponentIsNotComponent() {
        assertFalse(config.isComponent(NoComponent.class), "Class without @Component must be not treated as component");
    }

    @Test
    void componentIsComponent() {
        assertTrue(config.isComponent(TestComponent.class), "Class annotated with @Component must be treated as component");
    }

    @Test
    void primaryIsComponent() {
        assertTrue(config.isComponent(TestPrimaryComponent.class), "Class annotated with @Primary must be treated as component");
    }

    @Test
    void singletonIsComponent() {
        assertTrue(config.isComponent(TestSingletonComponent.class), "Class annotated with @Singleton must be treated as component");
    }

    @Test
    void myComponentIsComponent() {
        assertTrue(config.isComponent(TestMyComponent.class), "Class annotated with meta-annotation with @Component must be treated as component");
    }

    @Test
    void myMetaComponentIsComponent() {
        assertTrue(config.isComponent(TestMyMetaComponent.class), "Class annotated with meta-annotation with @Component must be treated as component");
    }

    @Test
    void classIsListedOnce() {
        var classes = config.listImplementations(TestSingleImplementationInterface.class);
        assertEquals(1, classes.size());
    }
}
