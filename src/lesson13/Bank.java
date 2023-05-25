package lesson13;

import lesson13.model.Account;
import lesson13.model.Client;

import java.util.*;

public class Bank {
    public final Map<Client, Set<Account>> clientAccounts;
    public final Map<Account, Client> accToClientMap;

    public Bank() {
        clientAccounts = new HashMap<>();
        accToClientMap = new HashMap<>();
    }

    public Set<Account> getAccounts(Client client) {
        return clientAccounts.getOrDefault(client, new HashSet<>());
    }

    public Client findClient(Account account) {  // O(N) search
        for (Map.Entry<Client, Set<Account>> entry : clientAccounts.entrySet()) {
            if (entry.getValue().contains(account)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Client findClientFaster(Account account) {   //search by Map
        return accToClientMap.getOrDefault(account, null);
    }
    public void addAccount(Account account, Client client) {
        Set<Account> accounts = clientAccounts.getOrDefault(client, new HashSet<>());
        accounts.add(account);
        clientAccounts.put(client, accounts);
        accToClientMap.put(account, client);
    }

    public void addClient(Client client) {
        clientAccounts.put(client, new HashSet<>());
    }
}
