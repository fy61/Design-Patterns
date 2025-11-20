package BehavioralPatterns.ChainResponsibility;

import org.junit.jupiter.api.Test;

public class ChainTest {
    @Test
    public void testChain() {
        Handler leader = new Leader();
        Handler manager = new Manager();
        Handler director = new Director();
        leader.setNext(manager);
        manager.setNext(director);
        leader.handleRequest(4);
    }

    abstract class Handler {
        protected Handler next;
        public void setNext(Handler next) { this.next = next; }
        public abstract void handleRequest(int days);
    }

    class Leader extends Handler {
        public void handleRequest(int days) {
            if (days <= 2) System.out.println("Leader approved " + days + " days");
            else if (next != null) next.handleRequest(days);
        }
    }

    class Manager extends Handler {
        public void handleRequest(int days) {
            if (days <= 5) System.out.println("Manager approved " + days + " days");
            else if (next != null) next.handleRequest(days);
        }
    }

    class Director extends Handler {
        public void handleRequest(int days) {
            System.out.println("Director approved " + days + " days");
        }
    }

}
