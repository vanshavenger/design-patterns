package abstract_factory.products;

import abstract_factory.GPU;

public class DellGPU implements GPU {
    @Override
    public void assemble() {
        System.out.println("Dell GPU created.");
    }
    
}
