package org.mahiiru.domain.use_cases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mahiiru.domain.models.Client;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
Requerimientos funcionalidad modifyClientByEmail:
→ Solo se puede modificar un Cliente del total que se encuentra en el HashMap de Clients
→ La funcionalidad debe recibir un parametro String para identificar el cliente a modificar
→ La funcionalidad debe recibir dos parametros String name, String email para modificar el Client
→ Se debe reemplazar al Cliente existente en el HashMap con el nuevo cliente
→ Se debe retornar el nuevo cliente obtenido de la funcionalidad
→ La cantidad de clientes antes y después de usar la funcionalidad debe ser la misma

Que no se va a hacer en la funcionalidad modifyClientByEmail:

→ No se va a validar las entradas de los String cliente seleccionado, nuevo nombre, nuevo email
→ No se va a modificar el archivo txt de los clientes
→ No se va a comprobar que el email es un correo valido.
→ La Clase Client solo contiene dos atributos, nombre y email, por lo tanto, la clase no debe tener nuevos atributos
 */

class ClientsTest {

    private Clients clientsUseCases;
    private HashMap<String, Client> clientsThatAreInClientsFile;
    private List<String> clientsNamesThatAreInClientsFile;
    private List<String> clientsEmailsThatAreInClientsFile;
    private int numberOfClientsThatAreInClientsFile;

    private String id;
    private String name;
    private String email;
    private Client newClient;
    private Client oldClient;




    @BeforeEach
    void setUp() {
        this.clientsUseCases = new Clients();
        this.clientsThatAreInClientsFile = clientsUseCases.getClients();
        this.clientsNamesThatAreInClientsFile = clientsThatAreInClientsFile.values().stream().map(Client::getName).toList();
        this.clientsEmailsThatAreInClientsFile = clientsThatAreInClientsFile.values().stream().map(Client::getEmail).toList();
        this.numberOfClientsThatAreInClientsFile = clientsThatAreInClientsFile.size();
        this.id = "cr.pavez01@gmail.com";
        this.name = "Pavez Cristobal";
        this.email = "cr.pavez01@gmail.com";
        this.newClient = new Client(name,email);
        this.oldClient = clientsThatAreInClientsFile.get(id);
    }


    @Test
    @DisplayName("Solo se puede modificar un Cliente del total que se encuentra en el HashMap de Clients")
    void modifyClientByEmailTestThatOneClientIsReplaced(){
        Client client = clientsUseCases.modifyClientByEmail(id,name,email);
        HashMap<String,Client> clients = clientsUseCases.getClients();
        List<String> clientsEmails = clients.values().stream().map(Client::getEmail).toList();
        List<String> clientsNames = clients.values().stream().map(Client::getName).toList();
        Assertions.assertArrayEquals(clientsEmailsThatAreInClientsFile.toArray(),clientsEmails.toArray());
        Assertions.assertTrue(clientsNames.contains(client.getName()));
        Assertions.assertFalse(clientsNamesThatAreInClientsFile.contains(client.getName()));
    }

    @Test
    @DisplayName("Se debe reemplazar al Cliente existente en el HashMap con el nuevo cliente")
    void modifyClientByEmailTestThatOldClientIsReplaced(){
        Client client = clientsUseCases.modifyClientByEmail(id,name,email);
        HashMap<String,Client> clients = clientsUseCases.getClients();
        Assertions.assertEquals(oldClient.getEmail(),clients.get(client.getEmail()).getEmail());
        Assertions.assertNotEquals(oldClient.getName(),clients.get(client.getEmail()).getName());
    }

    @Test
    @DisplayName("Se debe retornar el nuevo cliente obtenido de la funcionalidad")
    void modifyClientByEmailTestNewClientAndReturnClientAreEquals(){
        Client client = clientsUseCases.modifyClientByEmail(id,name,email);
        Assertions.assertEquals(newClient.getName(),client.getName());
        Assertions.assertEquals(newClient.getEmail(),client.getEmail());
    }

    @Test
    @DisplayName("La cantidad de clientes antes y después de usar la funcionalidad debe ser la misma")
    void modifyClientByEmailTestNumbersOfClientsAreEquals(){
        Client client = clientsUseCases.modifyClientByEmail(id,name,email);
        HashMap<String,Client> clients = clientsUseCases.getClients();
        Assertions.assertEquals(numberOfClientsThatAreInClientsFile,clients.size());
    }
}