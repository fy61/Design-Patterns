package BehavioralPatterns.IteratorPattern;

import org.junit.jupiter.api.Test;

public class IteratorPatternTest {

    @Test
    public void testIteration() {
        NameRepository repo = new NameRepository();
        for (String name : repo) {
            System.out.println("遍历到: " + name);
        }
    }
}