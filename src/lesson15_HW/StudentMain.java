package lesson15_HW;

public class StudentMain {
    public static void main(String[] args) {
        Student.addStudent(new Student(2, 1, 4, 3, "470", "Leo"));
        Student.addStudent(new Student(7, 4, 6, 3, "473", "Teo"));
        Student.addStudent(new Student(2, 1, 3, 2, "475", "Neo"));
        Student.addStudent(new Student(9, 9, 10, 5, "501", "Li"));
        Student.printStudents(3);
        Student.expelStudents();
        Student.getStudents();
    }
}
