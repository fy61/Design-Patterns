package BehavioralPatterns.VisitorPattern;


public interface Visitor {
    void visit(Developer developer);
    void visit(Manager manager);
}