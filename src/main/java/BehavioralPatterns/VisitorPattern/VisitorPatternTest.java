package BehavioralPatterns.VisitorPattern;


import org.junit.jupiter.api.Test;

public class VisitorPatternTest {

    @Test
    public void testVisitorPattern() {
        Employee dev = new Developer("Alice");
        Employee mgr = new Manager("Bob");

        Visitor reportVisitor = new ReportVisitor();
        dev.accept(reportVisitor);
        mgr.accept(reportVisitor);

        // 使用：无需修改Employee类！
        Visitor salaryVisitor = new SalaryVisitor();
        dev.accept(salaryVisitor);  // 输出：计算程序员 Alice 的薪资: 20000元
        mgr.accept(salaryVisitor);  // 输出：计算经理 Bob 的薪资: 30000元
    }
}