package org.mahiiru.data.management;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilesManagerTest {

    private FilesManager filesManager;

    @BeforeEach
    void setUp() {
        filesManager = new FilesManager();
    }

    @Test
    void getClientsTestListIsNotEmpty(){
        Assertions.assertFalse(filesManager.getClients().isEmpty());
    }

    @Test
    void getClientsTestNumberOfClientsAreEquals(){
        int numberOfClientsInClientsFile = 2;
        Assertions.assertEquals(numberOfClientsInClientsFile,filesManager.getClients().size());
    }

    @Test
    void getClientsTestNamesAreEquals() {
        List<String> clientsNamesThatAreInClientsFile = Arrays.asList(
                "Cristobal Pavez",
                "Cristobal Pavez"
        );
        List<String> clientsNames = filesManager.getClients()
                .stream().map(client -> client.toString().split(",")[0]).toList();
        Assertions.assertArrayEquals(clientsNamesThatAreInClientsFile.toArray(),clientsNames.toArray());
    }

    @Test
    void getClientsTestEmailsAreEquals() {
        List<String> clientsEmailsThatAreInClientsFile = Arrays.asList(
                "c.pavez07@ufromail.cl",
                "cr.pavez01@gmail.com"
        );
        List<String> clientsEmails = filesManager.getClients()
                .stream().map(client -> client.toString().split(",")[1]).toList();
        Assertions.assertArrayEquals(clientsEmailsThatAreInClientsFile.toArray(),clientsEmails.toArray());
    }
}