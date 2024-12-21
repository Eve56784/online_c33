package lesson9_HWTask1;

public class Workman implements InterfaceTask{
    @Override
    public void print() {
        System.out.println("\033[1;35mI'm a regular worker...\033[1;0m");
    }
}
