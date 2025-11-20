package BehavioralPatterns.VisitorPattern;


public class ReportVisitor implements Visitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("记录程序员: " + developer.getName());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("记录经理: " + manager.getName());
    }
}