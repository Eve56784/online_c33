package lesson9_HWTask1;

public class MyMain {
    public static void main(String[] args) {
        InterfaceTask boss = new Boss();
        InterfaceTask accountant = new Accountant();
        InterfaceTask workman = new Workman();
        boss.print();
        accountant.print();
        workman.print();
    }
}
