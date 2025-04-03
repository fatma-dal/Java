public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount() {
        accounts++;
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public static int getAccounts() {
        return accounts;
    }
    public static double getTotalMoney() {
        return totalMoney;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void deposit(double amount,String place) {
        if(place=="checking"){
            this.checkingBalance+=amount;
        }else{
            this.savingsBalance+=amount;
        }
        totalMoney+=amount;
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    public String withdraw(double amount,String place){
        String  msg="";
        if(place=="checking"){
            if(amount>this.checkingBalance){
                msg= "Sorry, you don't have enough money ";
            }else{
                this.checkingBalance-=amount;
                totalMoney-=amount;
                msg= "Please get your card";
            }
        }else{
            if(amount>this.savingsBalance){
                msg= "Sorry, you don't have enough money ";
            }else{
                this.savingsBalance-=amount;
                totalMoney-=amount;
                msg= "Please get your card";
            }
        }
        return msg;
    }

    // - all deposits and withdrawals should affect totalMoney
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public void getBalance(){
        System.out.println("Your Total Balance is : " +(getCheckingBalance()+getSavingsBalance()));
    }
}