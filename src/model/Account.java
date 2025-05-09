package model;

public class Account {
    private String accNumber;
    private int balance;

    public Account(String accNumber, int balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", accNumber, balance);
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
