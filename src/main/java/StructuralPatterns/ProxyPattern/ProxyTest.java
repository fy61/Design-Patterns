package StructuralPatterns.ProxyPattern;

import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    public void testProxy() {
        Image image = new ProxyImage("photo.jpg");
        image.display(); // 首次加载 + 显示
        image.display(); // 第二次仅显示
    }

    interface Image {
        void display();
    }

    // 真实类
    class RealImage implements Image {
        private String filename;
        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }
        private void loadFromDisk() {
            System.out.println("Loading " + filename);
        }
        @Override
        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    // 代理类
    class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // 延迟加载
            }
            realImage.display();
        }
    }

}
