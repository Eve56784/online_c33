package lesson8_HW;

import java.util.Objects;

public class Tiger extends Animal{
    public Tiger(){}
    @Override
    public void voice(){
        System.out.println("\tTigers meow and roar");
    }
    @Override
    public void eat(String food){
        if(Objects.equals(food, "meat"))
            System.out.println("\t\tTigers like to eat meat");
        else if(Objects.equals(food, "grass"))
            System.out.println("\t\tTigers don't like to eat grass");
        else
            System.out.println("\t\tTigers have never tried to eat " + food);
    }

}
