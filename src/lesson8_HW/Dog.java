package lesson8_HW;

import java.util.Objects;

public class Dog extends Animal {
    private Dog(){} //declaring constructor as "private" prevents the creation of instances outside the Dog class
    @Override
    public void voice() {
        System.out.println("\tDogs bark");
    }
    @Override
    public void eat(String food){
        if(Objects.equals(food, "trash") || Objects.equals(food, "meat"))
            System.out.println("\t\tDogs like to eat " + food);
        else if(Objects.equals(food, "grass"))
            System.out.println("\t\tDogs don't like to eat grass");
        else
            System.out.println("\t\tDogs have never tried to eat " + food);
    }
    public static void callVoice(){ //creating "static" methods to create a Dog object and call for Dog class methods
        Dog newDog = new Dog();
        newDog.voice();
    }
    public static void callEat(String food){
        Dog newDog = new Dog();
        newDog.eat(food);
    }
}
