package abstract_factory;

public class HpCPU implements CPU {
     @Override
    public void assemble() {
        System.out.println("HP CPU created");
    }
    
}
