package lesson6_HW;

import java.util.Scanner;

public class Task2 {
    public static class ATM{
        private int banknote100;
        private int banknote20;
        private int banknote50;

        public ATM(int banknote20, int banknote50, int banknote100){
            this.banknote20 = banknote20;
            this.banknote50 = banknote50;
            this.banknote100 = banknote100;
        }
        public void addBanknotes(int banknote20, int banknote50, int banknote100){
            this.banknote20+=banknote20;
            this.banknote50+=banknote50;
            this.banknote100+=banknote100;
        }
        public boolean withdrawMoney(int amount){
            int banknote100Needed = Math.min(amount/100, banknote100);
            amount -= banknote100Needed * 100;
            banknote100-=banknote100Needed;

            int banknote50Needed = Math.min(amount/50, banknote50);
            amount -= banknote50Needed * 50;
            banknote50 -= banknote50Needed;

            int banknote20Needed = Math.min(amount/20, banknote20);
            amount -= banknote20Needed * 20;
            banknote20-=banknote20Needed;

            if(amount==0){
                System.out.print("\u001B[36mThe operation was succesfully performed. \n20$ banknotes issued: \u001B[0m");
                System.out.print(banknote20Needed + "\u001B[36m\n50$ banknotes issued:\u001B[0m" + banknote50Needed);
                System.out.println("\u001B[36m\n100% banknotes issued: \u001B[0m"+banknote100Needed);
                return true;
            }else
                System.out.println("\u001B[31mWithdrawal error.\u001B[0m");return false;
        }
    }

    public static void main(String[] args) {
        ATM atm1 = new ATM(5,4,15);
        System.out.print("Enter the amount you want to withdraw: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        boolean check = atm1.withdrawMoney(amount);
        System.out.println("Operation success: " + check);
        atm1.addBanknotes(0,0,20);
    }
}

