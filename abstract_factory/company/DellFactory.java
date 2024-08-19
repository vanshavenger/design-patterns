package abstract_factory.company;

import abstract_factory.CPU;
import abstract_factory.GPU;
import abstract_factory.products.DellCPU;
import abstract_factory.products.DellGPU;

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