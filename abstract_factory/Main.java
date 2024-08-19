package abstract_factory;

public class Main {

    public static void main(String[] args) {
        Company company = new DellFactory();
        company.createGPU();
        company.createCPU();

        company = new HpFactory();
        company.createGPU().assemble();;
        company.createCPU().assemble();


    }
    
}
