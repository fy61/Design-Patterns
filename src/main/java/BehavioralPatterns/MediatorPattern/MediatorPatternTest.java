package BehavioralPatterns.MediatorPattern;

import org.junit.jupiter.api.Test;

public class MediatorPatternTest {

    @Test
    public void testChatMediator() {
        ChatMediator mediator = new ChatMediator();

        User alice = new User("Alice", mediator);
        User bob = new User("Bob", mediator);
        User charlie = new User("Charlie", mediator);

        mediator.addUser(alice);
        mediator.addUser(bob);
        mediator.addUser(charlie);

        alice.send("Hello everyone!");
    }
}
