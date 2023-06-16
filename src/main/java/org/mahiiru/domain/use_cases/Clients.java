package org.mahiiru.domain.use_cases;

import org.mahiiru.data.management.FilesManager;
import org.mahiiru.domain.models.Client;

import java.util.HashMap;

public class Clients {

    private HashMap<String, Client> clients;
    private final FilesManager manager;

    public Clients() {
        manager = new FilesManager();
        clients = getClientsData();
    }

    private HashMap<String, Client> getClientsData() {
        HashMap<String, Client> clients = new HashMap<>();
        manager.getClients().forEach(line -> {
            String[] clientLine = line.split(",");
            Client newClient = new Client(clientLine[0], clientLine[1]);
            clients.put(newClient.getEmail(), newClient);
        });
        return clients;
    }

    public void getClientsPrint(){
        this.clients.forEach(
                (email,client) -> System.out.println("Cliente :  \n Email : " + email + " \n Nombre : " + client.getName())
        );
    }

    public void postClient(String name, String email){
        Client client = new Client(name,email);
        this.clients.put(client.getEmail(),client);
        manager.postClients(this.clients);
    }

    public Client getClientByEmail(String email){
        return this.clients.get(email);
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }


    public Client modifyClientByEmail(String id, String name, String email) {
        Client client = new Client(name,email);
        this.clients.put(id,client);
        return this.clients.get(id);
    }
}
