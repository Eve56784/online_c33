package lesson6_HW;

public class Task1 {
    public static class CreditCard {
        private final String accountNumber;
        private double cardBalance;

        public CreditCard(String accountNumber, double cardBalance) {
            this.accountNumber = accountNumber;
            this.cardBalance = cardBalance;
        }

        public void printCardInfo(){
            System.out.println("\u001B[33mAcc number: \u001B[0m" + accountNumber + ". \u001B[33mCard balance: \u001B[0m" + cardBalance);
        }
        public void deposit(double amount){
            if(amount<=0){
                System.out.println("\u001B[31mError. Try again.\u001B[0m");
            }
            else {
                cardBalance += amount;
                System.out.println("\u001B[36mAccount number: \u001B[0m" + accountNumber);
                System.out.println("\u001B[36m\n+" + amount + "\nNew card balance: \u001B[0m" + cardBalance + "$");
            }
        }
        public void withdraw(double amount) {
            if (amount > cardBalance)
                System.out.println("\u001B[31mAccount number: " + accountNumber + ": Insufficient funds. Try again.\u001B[0m");
            else {
                cardBalance-=amount;
                System.out.println("Account number: " + accountNumber + "\n-" + amount + "$\nNew card balance: " + cardBalance + "$");
            }
        }
    }

    public static void main(String[] args) {
        CreditCard card1 = new CreditCard("123456789101", 10000);
        CreditCard card2 = new CreditCard("456786543789", 0);
        CreditCard card3 = new CreditCard("987654456788", 200);

        card1.deposit(2050);
        card2.deposit(323.4);
        card3.withdraw(304.8);

        card1.printCardInfo();
        card2.printCardInfo();
        card3.printCardInfo();
    }
}
