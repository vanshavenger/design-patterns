package abstract_factory.products;

import abstract_factory.GPU;

public class RealmeGPU implements GPU {
    
    @Override
    public void assemble() {
        System.out.println("Realme GPU created");
    }

    
}
