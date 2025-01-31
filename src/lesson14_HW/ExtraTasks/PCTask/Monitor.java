package lesson14_HW.ExtraTasks.PCTask;

import java.io.Serializable;

public class Monitor implements Serializable {
    private final String brand;
    private final String brightness;


    public Monitor(String brand, String brightness) {
        this.brand = brand;
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "\tMonitor: \n\t\tBrand:'" + brand + "'; \n\t\tBrightness: " + brightness + ";";
    }
}
