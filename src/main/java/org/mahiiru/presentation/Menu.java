package org.mahiiru.presentation;

import org.mahiiru.common.UseCasesOptions;
import org.mahiiru.domain.use_cases.Books;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Books booksUseCases;
    private Boolean isActive;

    private int useCaseSelected;

    public Menu() {
        this.booksUseCases = new Books();
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
}
