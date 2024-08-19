package abstract_factory;

public class DellCPU implements CPU {
     @Override
    public void assemble() {
        System.out.println("Dell CPU created");
    }
    
}
