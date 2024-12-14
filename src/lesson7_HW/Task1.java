package lesson7_HW;

import java.util.Scanner;

public class Task1 {
    static class Clinic{
        String name;

        Clinic (String name){
            this.name=name;
        }
        public void treat(){}
    }

    static class Surgeon extends Clinic{
        Surgeon(String name) {
            super(name);
        }
        @Override
        public void treat(){
            System.out.println("Surgeon " + name + " is performing surgery.");
        }
    }

    static class Dentist extends Clinic{
        Dentist(String name){
            super(name);
        }
        @Override
        public void treat(){
            System.out.println("Dentist " + name + " is treating teeth.");
        }
    }

    static class Therapist extends Clinic {
        Therapist(String name) {
            super(name);
        }

        @Override
        public void treat() {
            System.out.println("Therapist " + name + " is providing therapy.");
        }

        public void assignDoctor(Patient patient){
            switch (patient.treatmentPlan){
                case 1:
                    patient.doctor = new Surgeon("Dr. Williams"); break;
                case 2:
                    patient.doctor = new Dentist("Dr. Black"); break;
                default:
                    patient.doctor = new Therapist("Dr. Smith"); break;
            }
        }
    }

    static class Patient{
        int treatmentPlan;
        Clinic doctor;

        Patient(int treatmentPlan){
            this.treatmentPlan=treatmentPlan;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1/2/any: ");
        int choice = scanner.nextInt();
        Patient patient1 = new Patient(choice);
        Therapist therapist = new Therapist("Dr. Smith");
        therapist.assignDoctor(patient1);
        System.out.println("\nAssigned doctor is " + patient1.doctor.name + ".");
        patient1.doctor.treat();
    }
}
