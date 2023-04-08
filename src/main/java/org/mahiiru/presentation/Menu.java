package org.mahiiru.presentation;

import org.mahiiru.common.UseCasesOptions;
import org.mahiiru.domain.models.Client;
import org.mahiiru.domain.models.SaleDetails;
import org.mahiiru.domain.use_cases.Books;
import org.mahiiru.domain.use_cases.Clients;
import org.mahiiru.domain.use_cases.Sales;


import java.util.*;

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
        clientsUseCases.getClientsPrint();
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

    public void getSales(){
        System.out.println("=== MOSTRANDO VENTAS === \n");
        salesUseCases.getSales();
        System.out.println("=== MOSTRANDO VENTAS === \n");
    }

    public void getSaleByID(){
        try{
            System.out.println("Ingresa la id de la venta : \n");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            salesUseCases.getSaleByID(id);
        }catch (NoSuchElementException e){
            System.out.println("Debes ingresar una id valida.");
        }
    }

    public void postSale(){
        Client client = selectValidClient();
        List<SaleDetails> details = createCartSaleDetails();
        if(client != null && !details.contains(null)){
            salesUseCases.postSale(client,details);
        }else{
            System.out.println("No se pudo realizar la venta porque hay un objeto nulo.");
        }
    }

    private List<SaleDetails> createCartSaleDetails() {
        List<SaleDetails> cart = new ArrayList<>();
        int maxBooksNumber = validCount();
        buyBooks(maxBooksNumber,cart);
        return cart;
    }

    private void buyBooks(int maxBooksNumber, List<SaleDetails> cart) {
        int totalBooks = 0;
        while(totalBooks < maxBooksNumber){
            int numBooks = inputNumBooks(totalBooks,maxBooksNumber);
            cart.add(selectBookFromStock(numBooks));
            totalBooks += numBooks;
        }
    }

    private SaleDetails selectBookFromStock(int numBooks) {
        System.out.println("Selecciona la id del libro que deseas : \n");
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un numero entero.");
        }
        return this.booksUseCases.getSaleByIDAndNumBooks(id,numBooks);
    }

    private int inputNumBooks(int totalBooks, int maxBooksNumber) {
        System.out.println("Selecciona la id del libro y la cantidad de ese libro que deseas comprar.");
        int input = 0;
        boolean isNotValidNumber = true;
        while (isNotValidNumber){
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Ingresa la cantidad : \n");
                input = scanner.nextInt();
                if((totalBooks + input) < maxBooksNumber && input >= 1){
                    isNotValidNumber = false;
                }else{
                    System.out.println("Debes ingresar una cantidad valida de libros.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un numero entero.");
            }
        }
        return input;
    }


    private int validCount() {
        boolean isNotValid = true;
        int count = 0;
        while(isNotValid){
            System.out.println("Ingresa entre 1 y 10 la cantidad total de libros que desea comprar: \n");
            Scanner scanner = new Scanner(System.in);
            try {
                count = scanner.nextInt();
                if(count >= 1 && count <= 10){
                    isNotValid = false;
                }else{
                    System.out.println("Debes ingresar una cantidad valida de libros.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un numero entero.");
            }
        }
        return count;
    }

    private Client selectValidClient() {
        Client client;
        String email = "";
        try{
            System.out.println("Ingresa el email del cliente : \n");
            Scanner scanner = new Scanner(System.in);
            email = scanner.nextLine();
        }catch (NoSuchElementException e){
            System.out.println("Debes ingresar un email valido.");
        }
        client = clientsUseCases.getClientByEmail(email);
        return client;
    }
}
