package account;

import javax.swing.*;

public enum BankCode {

    ACCESS_BANK("Access Bank", "044"),
    AFRIBANK("Afribank", "014"),
    CITIBANK("Citibank", "023"),
    DIAMOND_BANK("Diamond Bank", "063"),
    ECOBANK("Ecobank", "050"),
    EQUITORIAL_TRUST_BANK("Equitorial Trust Bank", "040"),
    FIRST_BANK("First Bank", "011"),
    FCMB("FCMB", "214"),
    FIDELITY_BANK("Fidelity Bank", "070"),
    FINBANK("Finbank", "085"),
    GUARANTY_TRUST_BANK("Guaranty Trust Bank", "058"),
    INTERCONTINENTAL_BANK("Intercontinental Bank", "069"),
    OCEANIC_BANK("Oceanic Bank", "056"),
    BANKPHB("BankPhb", "082"),
    SKYE_BANK("Skye Bank", "076"),
    SPRING_BANK("SpringBank", "084"),
    STANBIC_IBTC("StanbicIBTC", "221"),
    STANDARD_CHARTERED_BANK("Standard Chartered Bank", "068"),
    STERLING_BANK("Sterling Bank", "232"),
    UNITED_BANK_FOR_AFRICA("United Bank for Africa", "033"),
    UNION_BANK("Union Bank", "032"),
    WEMA_BANK("Wema bank", "035"),
    ZENITH_BANK("Zenith Bank", "057"),
    UNITY_BANK("Unity bank", "215");



    private final String bankName;
    private final String bankCode;

    BankCode(String bankName, String bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public static String getCodeByName(String bankName) {
        for (BankCode myBankCode: BankCode.values()) {
            if (myBankCode.getBankName().equalsIgnoreCase(bankName)) {
                return myBankCode.getBankCode();
            }
        }
        throw new IllegalArgumentException("Bank " + bankName + " Not Found");

    }

}
