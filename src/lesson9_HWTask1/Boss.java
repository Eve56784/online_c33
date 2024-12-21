package lesson9_HWTask1;

public class Boss implements InterfaceTask{
    @Override
    public void print() {
        System.out.println("\033[1;33mI'm a BOSS...\033[1;0m");
    }
}
