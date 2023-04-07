package org.mahiiru.presentation;

import org.mahiiru.common.UseCasesOptions;
import org.mahiiru.domain.use_cases.Books;
import org.mahiiru.domain.use_cases.Clients;
import org.mahiiru.domain.use_cases.Sales;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

    private Boolean isActive;
    private Books booksUseCases;
    private Clients clientsUseCases;
    private Sales salesUseCases;

    private int useCaseSelected;

    public Menu() {
        this.booksUseCases = new Books();
        this.clientsUseCases = new Clients();
        this.salesUseCases = new Sales();
        this.isActive = true;
    }

    public void getUseCases() {
        System.out.println("=== MENÚ ===");
        for (UseCasesOptions option : UseCasesOptions.values()) {
            System.out.println(option.getDescription());
        }
    }

    public int getUseCaseSelected() {
        return useCaseSelected;
    }

    public void setUseCaseSelected() {
        System.out.println("Elija una opción: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int option = scanner.nextInt();
            this.useCaseSelected = option;
        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un numero entero.");
        }
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void getBooks() {
        System.out.println("=== MOSTRANDO LIBROS EN STOCK === \n");
        booksUseCases.getBooksStock();
        System.out.println("=== MOSTRANDO LIBROS EN STOCK === \n");
    }

    public void getClients() {
        System.out.println("=== MOSTRANDO CLIENTES === \n");
        clientsUseCases.getClients();
        System.out.println("=== MOSTRANDO CLIENTES === \n");
    }

    public void postClient(){
        System.out.println("Registrar a un nuevo cliente, se necesita nombre y email.");
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Ingresa el nombre : \n");
            String nombre = scanner.nextLine();
            System.out.println("Ingresa el email : \n");
            String email = scanner.nextLine();
            clientsUseCases.postClient(
                    nombre.replace(",",""),
                    email.replace(",","")
            );
        }catch (NoSuchElementException e){
            System.out.println("Debes ingresar un nombre y un email valido.");
        }
    }
}
