package abstract_factory.products;

import abstract_factory.CPU;

public class RealmeCPU implements CPU {
    @Override
    public void assemble() {
        System.out.println("Realme CPU created");
    }
  
}
