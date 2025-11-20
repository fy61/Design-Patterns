package BehavioralPatterns.StatePattern.StateTest2;

// 状态 D：商品售罄状态
public class SoldOutState implements VendingMachineState {

    VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("商品已售罄，无法投币（退还硬币）。");
    }

    @Override
    public void refundMoney() {
        System.out.println("商品已售罄，无法退币。");
    }

    @Override
    public void selectProduct() {
        System.out.println("商品已售罄。");
    }

    @Override
    public void dispense() {
        System.out.println("商品已售罄，无法出货。");
    }
}