package atmmachine.statepattern.models;

public class Account {

    private String accountNumbner;
    private double balance;

    public Account(String accountNumbner, double balance) {
        this.accountNumbner = accountNumbner;
        this.balance = balance;
    }

    public String getAccountNumbner() {
        return accountNumbner;
    }

    public void setAccountNumbner(String accountNumbner) {
        this.accountNumbner = accountNumbner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
