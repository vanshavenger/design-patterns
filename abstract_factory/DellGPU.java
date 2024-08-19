package abstract_factory;

public class DellGPU implements GPU {
    @Override
    public void assemble() {
        System.out.println("Dell GPU created.");
    }
    
}
