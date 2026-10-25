package account;

import java.util.Random;

public class accountNumber {

    public static String createAccount(String bankCode) {

    Random input = new Random();
    String accountNumber = "";

    for(int count = 1; count <= 9; count++) {
        int myNumber = input.nextInt(10);
        accountNumber += myNumber;
    }

        isValidNumber(bankCode, accountNumber);

            return accountNumber;
    }

    public static String isValidNumber(String bankCode, String accountNumber) {
        if(accountNumber == null || bankCode.length() != 3 || accountNumber.length() != 9)
            throw new IllegalArgumentException("Account Number Must Be Exactly 9 Digits");

        String totalSum = bankCode + accountNumber;

        int[] multipliers = {3, 7, 3, 3, 7, 3, 3, 7, 3, 3, 7, 3};

        int result = 0;
        for(int index = 0; index < totalSum.length() - 1; index++) {
            int currentNumber = Character.getNumericValue(totalSum.charAt(index));
            result += currentNumber * multipliers[index];
        }

        int lastDigit = result % 10;

        int calculatedResult = 10 - lastDigit;

        if(calculatedResult == 10){
            calculatedResult = 0;
        }

        String completed10DigitNumber = accountNumber + calculatedResult;

        int finalDigit = Character.getNumericValue(completed10DigitNumber.charAt(completed10DigitNumber.length() - 1));

        if(calculatedResult == finalDigit) {
            return accountNumber;
        }

        throw new IllegalArgumentException("Account Number Not Valid");
    }


//    public static void main(String[] args) {
//        String newAccount = createAccount("Access Bank");
//        System.out.println("Generated Account Number: " + newAccount);
//
//        String validatedAccount = isValidNumber("044", newAccount);
//        System.out.println("Validated Account: " + validatedAccount);
//    }

}