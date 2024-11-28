package lesson3HW;

public class Task4 {
    public static void main(String[] args){
        float n = 23.53f;
        int roundedVariableN;
        if (n-(int)n >= 0.5){
            roundedVariableN = (int)n + 1;}
            else{
                roundedVariableN =(int)n;
        }
        System.out.println("\tThe rounded value: " + roundedVariableN + ", the original value: " + n);
    }

}
