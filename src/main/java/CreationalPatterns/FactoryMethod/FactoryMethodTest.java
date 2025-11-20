package CreationalPatterns.FactoryMethod;// FactoryMethodTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryMethodTest {

    @Test
    public void testFactoryMethod() {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.createProduct();
        assertEquals("Product A", productA.getName());

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.createProduct();
        assertEquals("Product B", productB.getName());
    }

    // Product.java
    interface Product {
        String getName();
    }

    // ConcreteProductA.java
    class ConcreteProductA implements Product {
        public String getName() {
            return "Product A";
        }
    }

    // ConcreteProductB.java
    class ConcreteProductB implements Product {
        public String getName() {
            return "Product B";
        }
    }

    // Factory.java
    abstract class Factory {
        public abstract Product createProduct();
    }

    // ConcreteFactoryA.java
    class ConcreteFactoryA extends Factory {
        public Product createProduct() {
            return new ConcreteProductA();
        }
    }

    // ConcreteFactoryB.java
    class ConcreteFactoryB extends Factory {
        public Product createProduct() {
            return new ConcreteProductB();
        }
    }

}
