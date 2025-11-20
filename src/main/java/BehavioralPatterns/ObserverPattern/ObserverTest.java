package BehavioralPatterns.ObserverPattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ObserverTest {
    @Test
    public void testObserver() {
        WeChatPublicAccount account = new WeChatPublicAccount();
        Observer a = new Subscriber("Alice");
        Observer b = new Subscriber("Bob");
        account.subscribe(a);
        account.subscribe(b);
        account.publish("New article released!");
    }

    interface Observer {
        void update(String message);
    }

    class Subscriber implements Observer {
        private String name;
        public Subscriber(String name) { this.name = name; }
        public void update(String message) {
            System.out.println(name + " received: " + message);
        }
    }

    class WeChatPublicAccount {
        private List<Observer> observers = new ArrayList<>();
        public void subscribe(Observer o) { observers.add(o); }
        public void unsubscribe(Observer o) { observers.remove(o); }
        public void publish(String message) {
            for (Observer o : observers) o.update(message);
        }
    }

}
