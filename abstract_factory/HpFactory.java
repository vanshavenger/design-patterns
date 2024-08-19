package abstract_factory;

public class HpFactory extends Company {
    @Override
    public GPU createGPU() {
        return new HpGPU();
    }

    @Override
    public CPU createCPU() {
        return new HpCPU();
    }
    
}
