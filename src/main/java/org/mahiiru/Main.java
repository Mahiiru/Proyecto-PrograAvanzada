package org.mahiiru;


import org.mahiiru.presentation.Menu;



public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (menu.getActive()){
            menu.getUseCases();
            menu.setUseCaseSelected();
            switch (menu.getUseCaseSelected()) {
                case 0 -> menu.setActive(!menu.getActive());
                case 1 -> menu.getBooks();
                case 2 -> menu.getClients();
                case 3 -> menu.postClient();
                default -> System.out.println("Opcion invalida.");
            }
        }

    }

}