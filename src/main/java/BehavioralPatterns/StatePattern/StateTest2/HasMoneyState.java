package BehavioralPatterns.StatePattern.StateTest2;

// 状态 B：已投币状态
public class HasMoneyState implements VendingMachineState {

    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("已投币，请勿重复投币。");
    }

    @Override
    public void refundMoney() {
        System.out.println("退回硬币。");
        // 状态转换：已投币 -> 未投币
        vendingMachine.setCurrentState(vendingMachine.NO_MONEY_STATE);
    }

    @Override
    public void selectProduct() {
        System.out.println("商品选择成功。");
        // 状态转换：已投币 -> 售卖商品
        vendingMachine.setCurrentState(vendingMachine.SOLD_STATE);
    }

    @Override
    public void dispense() {
        System.out.println("请先选择商品。");
    }
}