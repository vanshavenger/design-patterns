package abstract_factory.company;

import abstract_factory.CPU;
import abstract_factory.GPU;
import abstract_factory.products.RealmeCPU;
import abstract_factory.products.RealmeGPU;

public class RealmeFactory extends Company {
    @Override
    public GPU createGPU() {
        return new RealmeGPU();
    }

    @Override
    public CPU createCPU() {
        return new RealmeCPU();
    }
    
}
