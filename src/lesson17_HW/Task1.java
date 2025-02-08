package lesson17_HW;

import java.time.LocalDate;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(hundredYearsOld(LocalDate.parse("2007-02-27")));
    }
    public static LocalDate hundredYearsOld(LocalDate localDate){
        return localDate.plusYears(100);
    }
}
