package BehavioralPatterns.StatePattern.StateTest2;

// 状态接口 (VendingMachineState)
public interface VendingMachineState {

    /** 投币操作 */
    void insertMoney();

    /** 退币操作 */
    void refundMoney();

    /** 选择商品操作 */
    void selectProduct();

    /** 出货完成操作 */
    void dispense();
}