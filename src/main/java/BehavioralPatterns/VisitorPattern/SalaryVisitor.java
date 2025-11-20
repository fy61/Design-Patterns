package BehavioralPatterns.VisitorPattern;

// 新增薪资计算访问者
public class SalaryVisitor implements Visitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("计算程序员 " + developer.getName() + " 的薪资: 20000元");
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("计算经理 " + manager.getName() + " 的薪资: 30000元");
    }
}