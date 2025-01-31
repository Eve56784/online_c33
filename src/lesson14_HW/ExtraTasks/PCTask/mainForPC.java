package lesson14_HW.ExtraTasks.PCTask;

import java.io.*;

public class mainForPC {
    public static void main(String[] args) throws FileNotFoundException {
        Processor processor = new Processor("Intel","Intel Core Ultra 5");
        Monitor monitor = new Monitor("HP", "300 nits");
        Keyboard keyboard = new Keyboard("Mechanical", "Logitech", true);
        PC pc = new PC(processor, monitor, keyboard);

        try(FileOutputStream fileOutputStream= new FileOutputStream("file.txt")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(pc);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

        try(FileInputStream fileInputStream = new FileInputStream("file.txt")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            PC deserPC = (PC) objectInputStream.readObject();
            System.out.println(deserPC);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
