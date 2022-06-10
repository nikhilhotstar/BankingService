package models;

import java.util.regex.Pattern;

public class Transaction {

    String denomination;
    TransactionType type;

    public Transaction(TransactionType type, String denomination){

        this.type = type;
        this.denomination = denomination;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }



    public static boolean isValidDenomination(String denomination){
        String trimmedDenomination=denomination.trim();
        return  Pattern.matches("^\\d+D \\d+C$",trimmedDenomination);
    }
    public Double convertDenominationsToCents(){
        String[] splits=denomination.trim().split("\\s+");
        Double dollars = Double.parseDouble(splits[0].substring(0,splits[0].length()-1));
        Double cents = Double.parseDouble(splits[1].substring(0,splits[1].length()-1));
        return dollars*100+cents;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "denomination='" + denomination + '\'' +
                ", type=" + type +
                '}';
    }
}
