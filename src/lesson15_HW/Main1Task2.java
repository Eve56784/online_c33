package lesson15_HW;

import java.util.LinkedList;

public class Main1Task2 {
    private final LinkedList<String> animals;

    public Main1Task2() {
        animals = new LinkedList<>();
    }

    public void addAnimal(String animal){
        animals.addFirst(animal);
    }

    public String removeAnimal(){
        if(!animals.isEmpty())
            return animals.removeLast();
        else
            return "Nothing";
    }

    public void animalsOutput(){
        System.out.println(animals);
    }
}
