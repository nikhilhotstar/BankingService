package models;

public class Customer {
    String name;
    String email;
    private final String accountNumber;

    public Customer(String name, String email, String accountNumber){
        this.name=name;
        this.email=email;
        this.accountNumber=accountNumber;
    }

    public String getName(){
        return this.name;
    }

    public String setName(String name){
        this.name=name;
        return name;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public String setEmail(String email){
        this.email=email;
        return email;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
