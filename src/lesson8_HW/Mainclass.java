package lesson8_HW;

import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        Animal rabbit1 = new Rabbit();
        Animal tiger2 = new Tiger();
        Dog.callVoice();
        rabbit1.voice();
        tiger2.voice();
        Scanner scanner = new Scanner(System.in);
        String food = scanner.nextLine();
        rabbit1.eat(food);
        tiger2.eat(food);
        Dog.callEat(food);
    }
}
