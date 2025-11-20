package CreationalPatterns.AbstractFactory;// AbstractFactoryTest.java
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory() {
        GUIFactory factory = new MacFactory();
        factory.createButton().click();
        factory.createTextField().input("Hello Mac");

        factory = new WindowsFactory();
        factory.createButton().click();
        factory.createTextField().input("Hello Windows");
    }

    // Button.java
    interface Button {
        void click();
    }

    // TextField.java
    interface TextField {
        void input(String text);
    }

    // MacButton.java
    class MacButton implements Button {
        public void click() {
            System.out.println("Mac button clicked.");
        }
    }

    // MacTextField.java
    class MacTextField implements TextField {
        public void input(String text) {
            System.out.println("Mac text input: " + text);
        }
    }

    // WindowsButton.java
    class WindowsButton implements Button {
        public void click() {
            System.out.println("Windows button clicked.");
        }
    }

    // WindowsTextField.java
    class WindowsTextField implements TextField {
        public void input(String text) {
            System.out.println("Windows text input: " + text);
        }
    }

    // GUIFactory.java
    interface GUIFactory {
        Button createButton();
        TextField createTextField();
    }

    // MacFactory.java
    class MacFactory implements GUIFactory {
        public Button createButton() {
            return new MacButton();
        }

        public TextField createTextField() {
            return new MacTextField();
        }
    }

    // WindowsFactory.java
    class WindowsFactory implements GUIFactory {
        public Button createButton() {
            return new WindowsButton();
        }

        public TextField createTextField() {
            return new WindowsTextField();
        }
    }

}
