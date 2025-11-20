package first.Prototype;

// PrototypeTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {

    @Test
    public void testPrototype() {
        Prototype p1 = new Prototype("Original");
        Prototype p2 = p1.clone();

        p2.setName("Cloned");

        assertEquals("Original", p1.getName());
        assertEquals("Cloned", p2.getName());
    }
}
