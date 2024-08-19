package abstract_factory;

public class HpGPU implements GPU {
    
    @Override
    public void assemble() {
        System.out.println("HP GPU created");
    }
    
}
