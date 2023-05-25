package lesson13;

import lesson13.model.Account;
import lesson13.model.Client;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // client 1
        bank.addClient(new Client("Ivanov", 32));
        bank.addAccount(new Account(1), new Client("Ivanov", 32));
        // client 2
        bank.addClient(new Client("Petrov", 34));
        bank.addAccount(new Account(2), new Client("Petrov", 34));
        bank.addAccount(new Account(3), new Client("Petrov", 34));
        bank.addAccount(new Account(4), new Client("Petrov", 34));
        // getAccounts
        Set<Account> accountList = bank.getAccounts(new Client("Petrov", 34));
        System.out.println(accountList);
        // getClient
        Client client = bank.findClient(new Account(1));
        System.out.println(client);
        client = bank.findClientFaster(new Account(1));
        System.out.println(client);
    }
}
