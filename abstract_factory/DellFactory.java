package abstract_factory;

public class DellFactory extends Company {
    @Override
    public GPU createGPU() {
        return new DellGPU();
    }

    @Override
    public CPU createCPU() {
        return new DellCPU();
    }
}