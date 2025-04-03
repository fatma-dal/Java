public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount bankAcount1=new BankAccount();
        BankAccount bankAcount2=new BankAccount();
        BankAccount bankAcount3=new BankAccount();

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        bankAcount1.deposit(200, "checking");
        bankAcount2.deposit(300, "savings");
        bankAcount3.deposit(200, "checking");

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        bankAcount1.withdraw(100, "checking");
        bankAcount2.withdraw(50, "savings");
        bankAcount3.withdraw(100, "checking");
        bankAcount1.getBalance();
        bankAcount2.getBalance();
        bankAcount3.getBalance();

        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("Number of account : "+BankAccount.getAccounts());
        System.out.println("Total Money : "+BankAccount.getTotalMoney());

    }
}