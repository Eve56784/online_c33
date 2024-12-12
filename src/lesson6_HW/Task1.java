package lesson6_HW;

public class Task1 {
    public static class CreditCard {
        private String accountNumber;
        private double cardBalance;

        public CreditCard(String accountNumber, double cardBalance) {
            this.accountNumber = accountNumber;
            this.cardBalance = cardBalance;
        }

        public void printCardInfo(String accountNumber, double cardBalance){
            System.out.println("Acc number: " + accountNumber + "Card balance: " + cardBalance);
        }
        public void deposit(double amount){
            if(amount<=0){
                System.out.println("\u001B[31mError. Try again.\u001B[0m");
            }
            else {
                cardBalance += amount;
                System.out.println("+" + amount + "$\nNew card balance: " + cardBalance + "$");
            }
        }
        public void withdraw(double amount) {
            if (amount > cardBalance)
                System.out.println("\u001B[31mInsufficient funds. Try again.\u001B[0m");
            else {
                cardBalance-=amount;
                System.out.println("-" + amount + "$\nNew card balance: " + cardBalance + "$");
            }
        }
    }
    public static void main(String[] args) {
        CreditCard card1 = new CreditCard("123456789101", 10000);
        CreditCard card2 = new CreditCard("456786543789", 0);
        CreditCard card3 = new CreditCard("987654456788", 399.8);
        card1.deposit(2050);
        card2.deposit(323.4);
        card3.withdraw(304.8);
    }
}
