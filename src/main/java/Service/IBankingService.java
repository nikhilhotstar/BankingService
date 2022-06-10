package Service;


import models.Customer;
import models.Transaction;

import java.util.List;

public interface IBankingService {
    public boolean addCustomer(Customer customer);
    public boolean removeCustomer(Customer customer);
    public boolean transact(Customer customer, Transaction transaction);
    public Double getBalance(Customer customer);
    public List<Transaction> getStatement(Customer customer);
}
