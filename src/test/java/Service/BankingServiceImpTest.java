package Service;

import models.Customer;
import models.Transaction;
import models.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankingServiceImpTest {

    @Test
    void addCustomer() {
        BankingServiceImp bank= new BankingServiceImp();
        Customer customer= new Customer("nikhil","abc","abc");
        Assertions.assertEquals(bank.getCustomer(customer.getAccountNumber()),null);
        bank.addCustomer(customer);
        Assertions.assertEquals(bank.getCustomer(customer.getAccountNumber()).getAccountNumber(),customer.getAccountNumber());
    }

    @Test
    void removeCustomer() {
        BankingServiceImp bank= new BankingServiceImp();
        Customer customer= new Customer("nikhil","abc","abc");
        bank.addCustomer(customer);
        Assertions.assertEquals(bank.getCustomer(customer.getAccountNumber()).getAccountNumber(),customer.getAccountNumber());
        bank.removeCustomer(customer);
        Assertions.assertEquals(bank.getCustomer(customer.getAccountNumber()),null);

    }

    @Test
    void assertBalanceForCredits() {
        BankingServiceImp bank= new BankingServiceImp();
        Customer customer= new Customer("nikhil","abc","abc");
        bank.addCustomer(customer);
        bank.transact(customer,new Transaction(TransactionType.CREDIT,"1D 10C"));
        Assertions.assertEquals(bank.getStatement(customer).size(),1);
        Assertions.assertEquals(bank.getBalance(customer),110D);
    }

    @Test
    void assertBalanceForDebits() {
        BankingServiceImp bank= new BankingServiceImp();
        Customer customer= new Customer("nikhil","abc","abc");
        bank.addCustomer(customer);
        bank.transact(customer,new Transaction(TransactionType.DEBIT,"1D 10C"));
        Assertions.assertEquals(bank.getStatement(customer).size(),1);
        Assertions.assertEquals(bank.getBalance(customer),-110D);
    }



    @Test
    void getStatement() {
    }

    @Test
    void getBalance() {
    }
}