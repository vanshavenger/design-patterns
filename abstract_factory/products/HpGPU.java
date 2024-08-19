package abstract_factory.products;

import abstract_factory.GPU;

public class HpGPU implements GPU {
    
    @Override
    public void assemble() {
        System.out.println("HP GPU created");
    }
    
}
