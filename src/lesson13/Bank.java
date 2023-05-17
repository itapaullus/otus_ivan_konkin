package lesson13;

import lesson13.model.Account;
import lesson13.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    public final Map<Client, List<Account>> clientAccounts;

    public Bank() {
        clientAccounts = new HashMap<>();
    }

    public List<Account> getAccounts(Client client) {
        return clientAccounts.getOrDefault(client, new ArrayList<>());
    }

    public Client findClient(Account account) {
        for (Map.Entry<Client, List<Account>> entry : clientAccounts.entrySet()) {
            if (entry.getValue().contains(account)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void addAccount(Account account, Client client) {
        List<Account> accounts = clientAccounts.getOrDefault(client, new ArrayList<>());
        accounts.add(account);
        clientAccounts.put(client, accounts);
    }

    public void addClient(Client client) {
        clientAccounts.put(client, new ArrayList<>());
    }
}
