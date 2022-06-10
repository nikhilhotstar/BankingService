package Service;


import Repository.BankStorageImpl;
import Repository.IBankStorage;
import models.Customer;
import models.Transaction;

import java.util.List;

public class BankingServiceImp implements IBankingService {
    private IBankStorage storage;
    public BankingServiceImp(){
        this.storage= new BankStorageImpl();
    }

    public boolean addCustomer(Customer customer){

        boolean isAccountNumberUnique = storage.addCustomer(customer);
        storage.setBalance(customer,0D);

        if (!isAccountNumberUnique){
            System.out.println(customer.getAccountNumber()+" is already used, try something else");
        }
        else{
            System.out.println(customer.toString()+"  onboarded");
        }
        return  isAccountNumberUnique;

    }

    public Customer getCustomer(String accountNumber){
        return storage.getCustomer(accountNumber);
    }


    public boolean removeCustomer(Customer customer){
        boolean wasCustomerPresent=storage.isCustomerValid(customer);
        if(!wasCustomerPresent){
            System.out.println(customer.toString()+" is not present in database");
        }
        else{
            storage.clearTransaction(customer);
            storage.clearBalance(customer);
            storage.removeCustomer(customer);
            System.out.println(customer.toString()+"  removed from database");
        }
        return wasCustomerPresent;
    }

    public boolean transact(Customer customer, Transaction transaction){
        boolean isCustomerValid= storage.isCustomerValid(customer);
        if(!isCustomerValid){
            System.out.println("Transacting customer is not a valid customer");
            return  false;
        }
        if(!Transaction.isValidDenomination(transaction.getDenomination())){
            System.out.println("Denominations entered was in incorrect format, try again");
            return  false;
        }

        Double currentAmount=storage.getBalance(customer);
        switch (transaction.getType()){
            case DEBIT -> {
                storage.setBalance(customer,currentAmount-transaction.convertDenominationsToCents());
                storage.addTransaction(customer,transaction);
            }
            case CREDIT -> {
                storage.setBalance(customer,currentAmount+transaction.convertDenominationsToCents());
                storage.addTransaction(customer,transaction);
            }
        }

        return  true;
    }

    public List<Transaction> getStatement(Customer customer){
        return storage.getALlTransactions(customer);
    }

    public Double getBalance(Customer customer){
        return storage.getBalance(customer);
    }


}
