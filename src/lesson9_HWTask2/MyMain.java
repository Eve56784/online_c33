package lesson9_HWTask2;

public class MyMain {
    private static Figure[] figures;
    public static void main(String[] args) {
        figures = new Figure[]{
                new Circle(3),
                new Rectangle(3.3, 10),
                new Triangle(5, 12, 13),
                new Circle(9),
                new Triangle(3, 7.6, 10.5)
        };
        double totalPerimeter = 0, totalArea = 0;
        for(Figure figure:figures){
            totalPerimeter+=figure.findThePerimeter();
            totalArea+=figure.findTheArea();
        }
        System.out.println("\tTotal perimeter equals to " + totalPerimeter +"\n\tTotal area equals to " + totalArea);
    }
}
