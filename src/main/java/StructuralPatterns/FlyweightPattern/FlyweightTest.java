package StructuralPatterns.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlyweightTest {
    @Test
    public void testFlyweightWithLogs() {
        System.out.println("=== 第1次获取Oak树 ===");
        Tree t1 = TreeFactory.getTree("Oak");
        t1.display(10, 20);

        System.out.println("=== 第2次获取Oak树 ===");
        Tree t2 = TreeFactory.getTree("Oak");
        t2.display(30, 40);

        System.out.println("=== 获取Pine树 ===");
        Tree t3 = TreeFactory.getTree("Pine");
        t3.display(50, 60);

        System.out.println("=== 再次获取Oak树 ===");
        Tree t4 = TreeFactory.getTree("Oak");
        t4.display(70, 80);

        // 验证对象共享
        assertSame(t1, t2);
        assertSame(t1, t4);
        assertNotSame(t1, t3);

        System.out.println("t1 == t2: " + (t1 == t2));
        System.out.println("t1 == t4: " + (t1 == t4));
        System.out.println("t1 == t3: " + (t1 == t3));
    }

    interface Tree {
        void display(int x, int y);
    }

    // 添加日志的具体享元类
    static class ConcreteTree implements Tree {
        private String type;

        public ConcreteTree(String type) {
            this.type = type;
            System.out.println("创建新的 ConcreteTree: " + type + " [内存地址: " + System.identityHashCode(this) + "]");
        }

        public void display(int x, int y) {
            System.out.println("Display " + type + " tree at (" + x + "," + y + ") [内存地址: " + System.identityHashCode(this) + "]");
        }
    }

    // 添加日志的享元工厂
    static class TreeFactory {
        private static final Map<String, Tree> treeMap = new HashMap<>();

        public static Tree getTree(String type) {
            System.out.println("请求获取树类型: " + type);
            if (treeMap.containsKey(type)) {
                System.out.println("找到缓存对象，直接返回");
            } else {
                System.out.println("未找到缓存，创建新对象");
            }

            return treeMap.computeIfAbsent(type, ConcreteTree::new);
        }
    }


}


