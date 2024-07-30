package Builder_Pattern;

public class Computer {
    private String cpu;
    private int ram;
    private String storage;
    private boolean isGraphicsCardEnabled;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public static class ComputerBuilder {
        private String cpu;
        private int ram;
        private String storage;
        private boolean isGraphicsCardEnabled;

        public ComputerBuilder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder withStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder withGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}