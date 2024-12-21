package lesson9_HWTask2;

public class Triangle extends Figure{
    private double side1, side2, side3;
    public Triangle(double side1, double side2, double side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    @Override
    double findTheArea() {
        double halfP = (side1+side2+side3)/2;
        System.out.println("The area of the triangle is " + (Math.sqrt(halfP*(halfP-side1)*(halfP-side2)*(halfP-side3))));
        return Math.sqrt(halfP*(halfP-side1)*(halfP-side2)*(halfP-side3));
    }

    @Override
    double findThePerimeter() {
        System.out.println("The perimeter of the triangle is " + (side3+side1+side2));
        return side3+side1+side2;
    }
}
