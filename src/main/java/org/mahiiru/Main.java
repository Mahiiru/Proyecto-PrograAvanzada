package org.mahiiru;

import org.mahiiru.data.management.FilesManager;
import org.mahiiru.domain.models.Book;
import org.mahiiru.domain.use_cases.Books;
import org.mahiiru.presentation.Menu;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (menu.getActive()){
            menu.getUseCases();
            menu.setUseCaseSelected();
            switch (menu.getUseCaseSelected()) {
                case 1 -> menu.getBooks();
                case 0 -> menu.setActive(!menu.getActive());
                default -> System.out.println("Opcion invalida.");
            }
        }

    }

}