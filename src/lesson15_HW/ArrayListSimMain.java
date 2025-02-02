package lesson15_HW;

public class ArrayListSimMain {
    public static void main(String[] args) {
        ArrayListSim<Number> simulation = new ArrayListSim<>();
        simulation.addElement(3.45);
        simulation.addElement(2000000000);
        simulation.addElement(0);
        simulation.addElement(1.56789);
        simulation.addElement(19);
        simulation.print();
        System.out.println(simulation.getElements(4));
        simulation.remove(2);
        simulation.print();
        simulation.clear();
        simulation.print();
        System.out.println(simulation.contains(1));
    }
}
