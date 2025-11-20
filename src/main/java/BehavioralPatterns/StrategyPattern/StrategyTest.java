package BehavioralPatterns;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    public void testStrategy() {
        PaymentContext context = new PaymentContext(new WeChatPay());
        context.execute(100);
        context = new PaymentContext(new AliPay());
        context.execute(200);
    }

    interface PaymentStrategy {
        void pay(double amount);
    }

    class WeChatPay implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " via WeChat");
        }
    }

    class AliPay implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " via AliPay");
        }
    }

    // 环境类
    class PaymentContext {
        private PaymentStrategy strategy;
        public PaymentContext(PaymentStrategy strategy) {
            this.strategy = strategy;
        }
        public void execute(double amount) {
            strategy.pay(amount);
        }
    }

}
