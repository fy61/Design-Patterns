package BehavioralPatterns.CommandPattern;

import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void testCommand() {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }

//    1. 命令接口
    interface Command {
        void execute();
    }

//    2. 接收者（实际执行操作的对象）
    class Light {
        void on() { System.out.println("Light ON"); }
        void off() { System.out.println("Light OFF"); }
    }

//    3. 具体命令（封装请求）
    class LightOnCommand implements Command {
        private Light light;
        public LightOnCommand(Light light) { this.light = light; }
        public void execute() { light.on(); }
    }

    class LightOffCommand implements Command {
        private Light light;
        public LightOffCommand(Light light) { this.light = light; }
        public void execute() { light.off(); }
    }

//    4. 调用者（触发命令）
    class RemoteControl {
        private Command command;
        public void setCommand(Command command) { this.command = command; }
        public void pressButton() { command.execute(); }
    }

}
