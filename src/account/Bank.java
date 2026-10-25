package account;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts = new ArrayList<>();

    public Account createAccount(String name, String pin, String bankName) {

        String bankCode = BankCode.getCodeByName(bankName);
        String generatedNumber = accountNumber.createAccount(bankCode);

        Account myAccount = new Account(pin, name, generatedNumber);

        accounts.add(myAccount);
        return myAccount;
    }

    public Account findAccount(String accountNumber) {
        for(Account account: accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public double checkBalance(String accountNumber, String pin) {
        Account myAccount = findAccount(accountNumber);

        return myAccount.getBalance(pin);
    }

    public void deposit(String accountNumber, int amount) {
        Account myAccount = findAccount(accountNumber);

        myAccount.deposit(amount);
    }

    public void withdraw(String accountNumber, String pin, int amount) {
        Account myAccount = findAccount(accountNumber);

        myAccount.withdraw(pin, amount);
    }

    public void transfer(String senderAccountNumber, String pin, String receiverAccountNumber, int amount) {
        Account senderAccount = findAccount(senderAccountNumber);
        Account receiverAccount = findAccount(receiverAccountNumber);

        senderAccount.withdraw(pin, amount);
        receiverAccount.deposit(amount);
    }

}

