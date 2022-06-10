//import main.java.Service.BankingServiceImp;
//import main.java.Service.IBankingService;
//import main.java.models.Customer;
//import main.java.models.Transaction;
//import main.java.models.TransactionType;

import Service.BankingServiceImp;
import Service.IBankingService;
import models.Customer;
import models.Transaction;
import models.TransactionType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Customer nikhil=new Customer("nikhil","nikhilghodke1210@gmail.com","1234");
        Scanner sc= new Scanner(System.in);
        IBankingService bank= new BankingServiceImp();
        System.out.println(bank.addCustomer(nikhil));

        System.out.println(nikhil.getName()+"  welcome ");
        int choice=-1;
        do{
            System.out.println("Choose 1 for Credit");
            System.out.println("Choose 2 for Debit");
            System.out.println("Choose 3 for Show");
            System.out.println("Choose 4 to get statement");
            System.out.println("Choose 5 for Exit");
            choice = Integer.parseInt(sc.nextLine());
            if(choice == 1){
                String denomination = sc.nextLine();
                System.out.println(denomination);
                Transaction credit= new Transaction(TransactionType.CREDIT,denomination);
                bank.transact(nikhil, credit);
            }
            else if(choice == 2){
                String denomination = sc.nextLine();
                Transaction credit= new Transaction(TransactionType.DEBIT,denomination);
                bank.transact(nikhil, credit);
            }
            else if(choice == 3){
                System.out.println(nikhil.getName()+ " has balance of "+bank.getBalance(nikhil)+"\n");
            }
            else if(choice == 4){
                System.out.println(nikhil.getName()+ " your statement is here "+bank.getStatement(nikhil)+"\n");
            }
        }while (choice!=5);

    }
}