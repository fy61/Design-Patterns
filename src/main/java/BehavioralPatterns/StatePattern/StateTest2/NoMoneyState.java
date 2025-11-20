package BehavioralPatterns.StatePattern.StateTest2;

// 状态 A：未投币状态
public class NoMoneyState implements VendingMachineState {

    VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("投入硬币成功。");
        // 状态转换：从未投币 -> 已投币
        vendingMachine.setCurrentState(vendingMachine.HAS_MONEY_STATE);
    }

    @Override
    public void refundMoney() {
        System.out.println("当前未投币，无法退币。");
    }

    @Override
    public void selectProduct() {
        System.out.println("请先投币。");
    }

    @Override
    public void dispense() {
        System.out.println("请先投币。");
    }
}