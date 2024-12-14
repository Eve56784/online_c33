package lesson7_HW;

public class ChangeApple {
        public static void main(String[] args) {
            Apple redApple = new Apple("Red");
            System.out.println("Current colour is " + redApple.getCurrentColour());
            redApple.changeColour("Green");
            System.out.println("Current colour is " + redApple.getCurrentColour());
        }
    }
