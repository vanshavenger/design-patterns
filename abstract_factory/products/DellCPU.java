package abstract_factory.products;

import abstract_factory.CPU;

public class DellCPU implements CPU {
     @Override
    public void assemble() {
        System.out.println("Dell CPU created");
    }
    
}
