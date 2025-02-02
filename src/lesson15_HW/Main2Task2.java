package lesson15_HW;

public class Main2Task2 {
    public static void main(String[] args) {
        Main1Task2 animalList = new Main1Task2();
        animalList.addAnimal("Tiger");
        animalList.addAnimal("Lion");
        animalList.addAnimal("Dolphin");
        animalList.animalsOutput();
        System.out.println(animalList.removeAnimal() + " was removed");
        animalList.animalsOutput();
    }
}
