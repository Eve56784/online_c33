package lesson15_HW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {
    private String name;
    private String groupNum;
    private int course;
    private int mathGrade;
    private int langGrade;
    private int physicsGrade;
    private static List<Student> students = new ArrayList<>();

    public Student(int physicsGrade, int langGrade, int mathGrade, int course, String groupNum, String name){
        this.physicsGrade = physicsGrade;
        this.langGrade = langGrade;
        this.mathGrade = mathGrade;
        this.course = course;
        this.groupNum = groupNum;
        this.name = name;
    }

    public float getAverageGrade(){
        return (float)(mathGrade+langGrade+physicsGrade)/3;
    }

    public String getName(){
        return name;
    }

    public int getCourse(){
        return course;
    }

    public void advanceCourse(){
        course++;
    }

    public static void addStudent(Student student){
        students.add(student);
    }

    public static void expelStudents(){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getAverageGrade()<3)
                iterator.remove();
            else if(student.course>=5)
                student.name+="(Graduated)";
            else
                student.advanceCourse();
        }
    }

    public static void printStudents(int course){
        System.out.print("Students currently in the " + course + " year:");
        for(Student student: students){
            if(student.getCourse()==course){
                System.out.print("\t\n" + student.getName());
            }
        }
    }

    public static void getStudents(){
       for(Student student:students){
           System.out.printf("\nName: %s\n\tCourse: %d\n\tAverage grade: %.2f\n\tGroup: %s"
                   ,student.name,student.course,student.getAverageGrade(),student.groupNum);
       }
    }

    @Override
    public String toString() {
        return "Student " + name + ":\n\t" + "Course: " + course + "\n\tGroup: " + groupNum + "\n\tAverage score: "
                + getAverageGrade() + "\n";
    }
}
