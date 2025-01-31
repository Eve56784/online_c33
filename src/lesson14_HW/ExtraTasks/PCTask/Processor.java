package lesson14_HW.ExtraTasks.PCTask;

import java.io.Serializable;

public class Processor implements Serializable {
    private final String brand;
    private final String model;

    public Processor(String brand, String model){
        this.brand=brand;
        this.model=model;
    }

    @Override
    public String toString() {
        return "\tProcessor: \n\t\tBrand:'" + brand + "'; \n\t\tModel: " + model + ";";
    }
}
