package Repository;


import models.Customer;
import models.Transaction;

import java.util.List;

public interface IBankStorage {

    public boolean addCustomer(Customer customer);
    public Customer getCustomer(String accountId);
    public boolean removeCustomer(Customer customer);
    public boolean isCustomerValid(Customer customer);
    public Double getBalance(Customer customer);
    public Double setBalance(Customer customer, Double balance);
    public List<Transaction> getALlTransactions(Customer customer);
    public List<Transaction> addTransaction(Customer customer, Transaction transaction);
    public boolean clearTransaction(Customer customer);
    public boolean clearBalance(Customer customer);
}
