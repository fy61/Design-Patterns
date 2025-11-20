package StructuralPatterns.CompositePattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    @Test
    public void testComposite() {
        Folder root = new Folder("root");
        root.add(new FileLeaf("a.txt"));
        root.add(new SymbolicLink("link", "/path/to/file"));
        Folder sub = new Folder("sub");
        sub.add(new FileLeaf("b.txt"));
        sub.add(new FileLeaf("c.txt"));
        root.add(sub);

        root.show();
    }

    // 组件接口
    interface FileComponent {
        void show();
    }

    // 叶子节点
    class FileLeaf implements FileComponent {
        private String name;
        public FileLeaf(String name) { this.name = name; }
        public void show() { System.out.println("File: " + name); }
    }

    // 组合节点
    class Folder implements FileComponent {
        private String name;
        private List<FileComponent> children = new ArrayList<>();

        public Folder(String name) { this.name = name; }

        public void add(FileComponent component) { children.add(component); }

        public void show() {
            System.out.println("Folder: " + name);
            for (FileComponent c : children) c.show();
        }
    }

    // 新增符号链接类型
    class SymbolicLink implements FileComponent {
        private String name;
        private String target;

        public SymbolicLink(String name, String target) {
            this.name = name;
            this.target = target;
        }

        public void show() {
            System.out.println("SymbolicLink: " + name + " -> " + target);
        }
    }

}
