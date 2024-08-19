package abstract_factory.company;

import abstract_factory.CPU;
import abstract_factory.GPU;

public abstract class Company {
    public abstract GPU createGPU();
    public abstract CPU createCPU();
}
