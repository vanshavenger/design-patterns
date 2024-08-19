package abstract_factory.products;

import abstract_factory.CPU;

public class HpCPU implements CPU {
     @Override
    public void assemble() {
        System.out.println("HP CPU created");
    }
    
}
