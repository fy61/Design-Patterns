package StructuralPatterns.DecoratorPattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {


    @Test
    public void testDecorator() {
        Coffee coffee = new BasicCoffee(); //coffee->BasicCoffee
        coffee = new MilkDecorator(coffee);//coffee->MilkDecorator->BasicCoffee
        coffee = new SugarDecorator(coffee);//coffee->SugarDecorator->MilkDecorator->BasicCoffee

        assertEquals("Basic Coffee, Milk, Sugar", coffee.getDescription());
        assertEquals(13.0, coffee.cost());
    }

    // 抽象组件
    interface Coffee {
        String getDescription();

        double cost();
    }

    // 具体组件
    class BasicCoffee implements Coffee {
        public String getDescription() {
            return "Basic Coffee";
        }

        public double cost() {
            return 10.0;
        }
    }

    // 抽象装饰者
    abstract class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }
    }

    // 具体装饰者
    class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
            // 调用 CoffeeDecorator 构造器
            // CoffeeDecorator 的构造器执行：
            // this.coffee = coffee;  ← 保存被装饰对象！
        }

        public String getDescription() {
            return coffee.getDescription() + ", Milk";
            //     ↑
            // 这个coffee字段是从CoffeeDecorator继承来的！
            // 它指向被装饰的对象
        }

        public double cost() {
            return coffee.cost() + 2.0;
        }
    }

    class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        public String getDescription() {
            return coffee.getDescription() + ", Sugar";
        }

        public double cost() {
            return coffee.cost() + 1.0;
        }
    }

}
