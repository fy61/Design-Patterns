package BehavioralPatterns.StatePattern.StateTest2;

public class StatePatternDemo {
    public static void main(String[] args) {
        // 初始化贩卖机，假设有 2 个商品
        VendingMachine machine = new VendingMachine(2);

        // 场景 1：正常购买流程
        System.out.println("\n--- 场景 1: 正常购买 ---");
        machine.selectProduct(); // 行为：请先投币
        machine.insertMoney();  // 行为：投入硬币成功 -> 状态: HAS_MONEY
        machine.refundMoney();  // 行为：退回硬币 -> 状态: NO_MONEY

        // 重试正常流程
        machine.insertMoney();  // 状态: HAS_MONEY
        machine.selectProduct(); // 行为：选择成功 -> 状态: SOLD
        machine.dispense();      // 行为：出货 -> 状态: NO_MONEY (库存 1)

        // 场景 2：继续购买直到售罄
        System.out.println("\n--- 场景 2: 售罄流程 ---");
        machine.insertMoney();  // 状态: HAS_MONEY
        machine.selectProduct(); // 状态: SOLD
        machine.insertMoney();  // 行为：正在出货中
        machine.dispense();      // 行为：出货 -> 状态: SOLD_OUT (库存 0)

        // 场景 3：售罄后尝试操作
        System.out.println("\n--- 场景 3: 售罄后操作 ---");
        machine.insertMoney();  // 行为：商品已售罄，无法投币
        machine.selectProduct(); // 行为：商品已售罄
    }
}