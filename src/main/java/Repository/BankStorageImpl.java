package Repository;

import models.Customer;
import models.Transaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankStorageImpl implements IBankStorage {
    private HashMap<String, Customer> customers;
    private HashMap<String,Double> balances;
    HashMap<String, List<Transaction>> transactions;

    public BankStorageImpl(){
        this.customers = new HashMap<>();
        this.balances = new HashMap<>();
        this.transactions = new HashMap<>();
    }

    public boolean addCustomer(Customer customer){
        if(customers.containsKey(customer.getAccountNumber()))
            return  false;
        else{
            customers.put(customer.getAccountNumber(),customer);

            return true;
        }

    }

    public Customer getCustomer(String accountId){
        return customers.getOrDefault(accountId,null);
    }

    public boolean isCustomerValid(Customer customer){
        return customers.containsKey(customer.getAccountNumber())?true:false;
    }

    public boolean removeCustomer(Customer customer){
        if(!isCustomerValid(customer))
            return  false;
        else{
            customers.remove(customer.getAccountNumber());
            return true;
        }
    }

    public Double getBalance(Customer customer){
        return balances.getOrDefault(customer.getAccountNumber(),-1D);
    }

    public Double setBalance(Customer customer, Double newBalance){
        if(! isCustomerValid(customer))
            return  -1D;
        else {
            balances.put(customer.getAccountNumber(), newBalance);
            return newBalance;
        }
    }

    public List<Transaction> getALlTransactions(Customer customer){
        return transactions.getOrDefault(customer.getAccountNumber(), null);
    }

    public List<Transaction> addTransaction(Customer customer, Transaction transaction){
        if(!isCustomerValid(customer))
            return  null;
        else{
            List<Transaction> customerTransactions= transactions.getOrDefault(customer.getAccountNumber(), new ArrayList<>());
            customerTransactions.add(transaction);
            transactions.put(customer.getAccountNumber(), customerTransactions);
            return customerTransactions;
        }
    }

    public boolean clearTransaction(Customer customer){
        if(!isCustomerValid(customer)){
            return false;
        }
        else{
            transactions.remove(customer.getAccountNumber());
            return  true;
        }
    }

    public boolean clearBalance(Customer customer){
        if(!isCustomerValid(customer)){
            return false;
        }
        else{
            balances.remove(customer.getAccountNumber());
            return  true;
        }
    }

}
