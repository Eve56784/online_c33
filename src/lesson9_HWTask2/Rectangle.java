package lesson9_HWTask2;

public class Rectangle extends Figure{
    private final double height, side;
    public Rectangle(double height, double side){
        this.height=height;
        this.side=side;
    }

    @Override
    double findTheArea() {
        System.out.println("The area of the rectangle is " + (height*side));
        return height*side;
    }

    @Override
    double findThePerimeter() {
        System.out.println("The perimeter of the rectangle is " + (2*(height+side)));
        return 2*(height+side);
    }
}
