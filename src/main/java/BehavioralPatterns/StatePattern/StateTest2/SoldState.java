package BehavioralPatterns.StatePattern.StateTest2;

// 状态 C：售卖商品状态
public class SoldState implements VendingMachineState {

    VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("正在出货中，请稍候。");
    }

    @Override
    public void refundMoney() {
        System.out.println("正在出货中，无法退币。");
    }

    @Override
    public void selectProduct() {
        System.out.println("正在出货中，请勿重复选择。");
    }

    @Override
    public void dispense() {
        vendingMachine.releaseProduct(); // 真正执行出货

        if (vendingMachine.getCount() > 0) {
            // 状态转换：出货完成，回到未投币状态
            vendingMachine.setCurrentState(vendingMachine.NO_MONEY_STATE);
        } else {
            // 状态转换：售罄，进入售罄状态
            vendingMachine.setCurrentState(vendingMachine.SOLD_OUT_STATE);
        }
    }
}