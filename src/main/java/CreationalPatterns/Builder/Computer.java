package first.Builder;

// Computer.java
public class Computer {
    private String cpu;
    private String gpu;
    private String ram;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
    }

    public static class Builder {
        private String cpu;
        private String gpu;
        private String ram;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer[cpu=" + cpu + ", gpu=" + gpu + ", ram=" + ram + "]";
    }
}
