package BehavioralPatterns.TemplateMethodPattern;

import org.junit.jupiter.api.Test;

public class TemplateMethodTest {
    @Test
    public void testTemplate() {
        Beverage tea = new Tea();
        tea.make();
        Beverage coffee = new Coffee();
        coffee.make();
    }

    abstract class Beverage {
        public final void make() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }
        void boilWater() { System.out.println("Boiling water"); }
        abstract void brew();
        abstract void addCondiments();
        void pourInCup() { System.out.println("Pouring into cup"); }
    }

    class Tea extends Beverage {
        void brew() { System.out.println("Steeping the tea"); }
        void addCondiments() { System.out.println("Adding lemon"); }
    }

    class Coffee extends Beverage {
        void brew() { System.out.println("Dripping coffee through filter"); }
        void addCondiments() { System.out.println("Adding sugar and milk"); }
    }

}
