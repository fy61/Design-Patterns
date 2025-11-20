package BehavioralPatterns.MementoPattern;

public class TextEditor {
    private String text;

    public void setText(String text) {
        System.out.println("输入文本: " + text);
        this.text = text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
        System.out.println("恢复文本为: " + text);
    }

    public static class Memento {
        private final String text;
        public Memento(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }
}
