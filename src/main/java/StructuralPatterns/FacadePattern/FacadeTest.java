package StructuralPatterns.FacadePattern;

import org.junit.jupiter.api.Test;

public class FacadeTest {
    @Test
    public void testFacade() {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }

    class CPU {
        void start() { System.out.println("CPU started"); }
    }
    class Memory {
        void load() { System.out.println("Memory loaded"); }
    }
    class Disk {
        void boot() { System.out.println("Disk booted"); }
    }

    // 外观类
    class ComputerFacade {
        private CPU cpu;
        private Memory memory;
        private Disk disk;

        public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.disk = new Disk();
        }

        public void start() {
            cpu.start();
            memory.load();
            disk.boot();
            System.out.println("Computer started successfully!");
        }
    }

}
