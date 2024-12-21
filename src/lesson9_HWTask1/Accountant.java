package lesson9_HWTask1;

public class Accountant implements InterfaceTask{
    @Override
    public void print() {
        System.out.println("\033[1;34mI'm an accountant...\033[1;0m");
    }
}
