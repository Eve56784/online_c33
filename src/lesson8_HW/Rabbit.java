package lesson8_HW;

import java.util.Objects;

public class Rabbit extends Animal{
    public Rabbit(){}
    @Override
    public void voice(){
        System.out.println("\tRabbits squeak");
    }
    @Override
    public void eat(String food){
        if(Objects.equals(food, "meat"))
            System.out.println("\t\tRabbits don't like to eat meat");
        else if(Objects.equals(food, "grass"))
            System.out.println("\t\tRabbits like to eat grass");
        else
            System.out.println("\t\tRabbits have never tried to eat " + food);
    }
}
