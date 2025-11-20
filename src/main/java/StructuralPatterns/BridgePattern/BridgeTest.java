package StructuralPatterns.BridgePattern;

import org.junit.jupiter.api.Test;

public class BridgeTest {
    @Test
    public void testBridge() {
        Device tv = new TV();
        Remote remote = new AdvancedRemote(tv);
        remote.togglePower(); // TV on
        remote.togglePower(); // TV off
    }

    // 实现层接口
    interface Device {
        void turnOn();
        void turnOff();
    }

    // 具体设备
    class TV implements Device {
        public void turnOn() { System.out.println("TV on"); }
        public void turnOff() { System.out.println("TV off"); }
    }
    class Radio implements Device {
        public void turnOn() { System.out.println("Radio on"); }
        public void turnOff() { System.out.println("Radio off"); }
    }

    // 抽象层
    abstract class Remote {
        protected Device device;
        public Remote(Device device) { this.device = device; }
        abstract void togglePower();
    }

    // 扩展抽象层
        class AdvancedRemote extends Remote {
        private boolean on = false;
        public AdvancedRemote(Device device) { super(device); }
        public void togglePower() {
            if (on) device.turnOff();
            else device.turnOn();
            on = !on;
        }
    }

}
