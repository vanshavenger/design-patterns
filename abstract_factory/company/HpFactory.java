package abstract_factory.company;

import abstract_factory.CPU;
import abstract_factory.GPU;
import abstract_factory.products.HpCPU;
import abstract_factory.products.HpGPU;

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
