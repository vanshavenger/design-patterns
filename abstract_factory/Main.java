package abstract_factory;

import abstract_factory.company.Company;
import abstract_factory.company.DellFactory;
import abstract_factory.company.HpFactory;
import abstract_factory.company.RealmeFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company dellCompany = new DellFactory();
        Company hpCompany = new HpFactory();
        Company realmeCompany = new RealmeFactory();


        List. of(dellCompany, hpCompany, realmeCompany)
            .forEach(company -> {
                company.createCPU().assemble();
                company.createGPU().assemble();
            });

    }
    
}
