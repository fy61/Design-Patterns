package BehavioralPatterns.InterpreterPattern;

import org.junit.jupiter.api.Test;

public class InterpreterPatternTest {

    @Test
    public void testInterpreter() {
        Expression expr = new AddExpression(new NumberExpression(5), new NumberExpression(10));
        System.out.println("5 + 10 = " + expr.interpret());
    }
}