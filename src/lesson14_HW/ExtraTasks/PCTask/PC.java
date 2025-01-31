package lesson14_HW.ExtraTasks.PCTask;

import java.io.Serializable;

public class PC implements Serializable {
    private Processor processor;
    private Monitor monitor;
    private Keyboard keyboard;

    public PC(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "PC: \n" + processor + "\n" + monitor + "\n"+ keyboard;
    }
}
