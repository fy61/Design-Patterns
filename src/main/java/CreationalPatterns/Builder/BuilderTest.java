package first.Builder;
// BuilderTest.java
import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    public void testBuilder() {
        Computer computer = new Computer.Builder()
                .cpu("Intel i9")
                .gpu("RTX 4090")
                .ram("64GB")
                .build();
        System.out.println(computer);
    }
}
