package Builder_Pattern;

public class BuilderTest {
    public static void main(String[] args) {

        Computer basicComputer = new Computer.ComputerBuilder()
                .withCpu("Intel Core i3")
                .withRam(8)
                .withStorage("256GB SSD")
                .build();

        System.out.println("Basic Computer:");
        System.out.println("CPU: " + basicComputer.getCpu());
        System.out.println("RAM: " + basicComputer.getRam() + "GB");
        System.out.println("Storage: " + basicComputer.getStorage());

        Computer gamingComputer = new Computer.ComputerBuilder()
                .withCpu("Intel Core i9")
                .withRam(16)
                .withStorage("1TB NVMe SSD")
                .withGraphicsCardEnabled(true)
                .build();

        System.out.println("\nGaming Computer:");
        System.out.println("CPU: " + gamingComputer.getCpu());
        System.out.println("RAM: " + gamingComputer.getRam() + "GB");
        System.out.println("Storage: " + gamingComputer.getStorage());
        System.out.println("Graphics Card: " + (gamingComputer.isGraphicsCardEnabled() ? "Enabled" : "Disabled"));
    }
}