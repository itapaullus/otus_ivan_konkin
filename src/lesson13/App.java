package lesson13;

import lesson13.model.Account;
import lesson13.model.Client;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // client 1
        Client client1 = new Client("Ivanov", 32);
        bank.addClient(client1);
        bank.addAccount(new Account(1), client1);
        // client 2
        Client client2 = new Client("Petrov", 34);
        bank.addClient(client2);
        bank.addAccount(new Account(2), client2);
        bank.addAccount(new Account(3), client2);
        bank.addAccount(new Account(4), client2);
        // getAccounts
        List<Account> accountList = bank.getAccounts(client2);
        System.out.println(accountList);
        // getClient
        Client client = bank.findClient(new Account(1));
        System.out.println(client);
    }
}
