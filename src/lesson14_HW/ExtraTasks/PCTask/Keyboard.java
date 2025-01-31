package lesson14_HW.ExtraTasks.PCTask;

import java.io.Serializable;

public class Keyboard implements Serializable {
    private final String type;
    private boolean isModified;
    private final String brand;

    public Keyboard(String type, String brand, Boolean isModified) {
        this.type = type;
        this.isModified=isModified;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "\tKeyboard: \n\t\tBrand:'" + brand + "'; \n\t\tisModified: " + isModified + ";\n\t\t Type: " +type+";";
    }
}
