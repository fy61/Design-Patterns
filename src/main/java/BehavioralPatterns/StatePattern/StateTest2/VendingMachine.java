package BehavioralPatterns.StatePattern.StateTest2;

// 上下文类 (VendingMachine)
public class VendingMachine {

    // 所有可能的状态实例 (常量或单例)
    public final VendingMachineState NO_MONEY_STATE = new NoMoneyState(this);
    public final VendingMachineState HAS_MONEY_STATE = new HasMoneyState(this);
    public final VendingMachineState SOLD_STATE = new SoldState(this);
    public final VendingMachineState SOLD_OUT_STATE = new SoldOutState(this);

    // 贩卖机当前状态 (引用)
    private VendingMachineState currentState;

    // 库存 (用于演示)
    private int count = 0;

    public VendingMachine(int initialCount) {
        this.count = initialCount;

        // 初始化状态
        if (count > 0) {
            this.currentState = NO_MONEY_STATE;
        } else {
            this.currentState = SOLD_OUT_STATE;
        }
        System.out.println("--- 贩卖机初始化完成，当前商品数量：" + count + " ---");
    }

    // 核心方法：设置状态（供状态类内部调用）
    public void setCurrentState(VendingMachineState newState) {
        this.currentState = newState;
        System.out.println("== 状态转换: 当前状态变为 [" + newState.getClass().getSimpleName() + "] ==");
    }

    // 扣减库存方法
    public void releaseProduct() {
        System.out.println(">> 正在出货... <<");
        if (count > 0) {
            count--;
        }
        System.out.println(">> 出货完成。剩余库存: " + count + " <<");
    }

    // 将用户操作委托给当前状态对象
    public void insertMoney() {
        currentState.insertMoney();
    }

    public void refundMoney() {
        currentState.refundMoney();
    }

    public void selectProduct() {
        currentState.selectProduct();
    }

    public void dispense() {
        currentState.dispense();
    }

    public int getCount() {
        return count;
    }

    // Getter 方法方便状态类获取其他状态实例
    // ... (省略 Getter 方法)
}