package BehavioralPatterns.VisitorPattern;


public interface Employee {
    void accept(Visitor visitor);
}
