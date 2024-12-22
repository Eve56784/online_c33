package lesson9_HWTask2;

public class Circle extends Figure{
    private final double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    double findTheArea() {
        System.out.println("The area of the circle is " + (radius*radius*3.14));
        return radius*radius*3.14;
    }

    @Override
    double findThePerimeter() {
        System.out.println("The perimeter of the circle is " + (2*3.14*radius));
        return 2*3.14*radius;
    }
}
