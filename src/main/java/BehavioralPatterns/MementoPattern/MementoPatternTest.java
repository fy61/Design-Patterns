package BehavioralPatterns.MementoPattern;


import org.junit.jupiter.api.Test;

public class MementoPatternTest {

    @Test
    public void testTextEditor() {
        TextEditor editor = new TextEditor();

        editor.setText("第一次输入");
        TextEditor.Memento backup = editor.save();

        editor.setText("修改后的文本");
        editor.restore(backup);
    }
}
