package by.degree.learn.nano.framework;

import by.degree.learn.nano.framework.test.NoComponent;
import by.degree.learn.nano.framework.test.TestMyMetaComponent;
import by.degree.learn.nano.framework.JavaConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaConfigListImplementationTest {

    JavaConfig config = new JavaConfig("by.degree.learn.nano.framework.test");

    @Test
    void listNoComponent() {
        assertTrue(config.listImplementations(NoComponent.class).isEmpty());
    }

    @Test
    void listMySuperMetaComponent() {
        assertEquals(1, config.listImplementations(TestMyMetaComponent.class).size(), "There must be one component found");
    }
}
