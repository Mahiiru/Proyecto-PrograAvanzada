package org.mahiiru.data.management;

import org.mahiiru.common.Resources;
import org.mahiiru.domain.models.Book;
import org.mahiiru.domain.models.Client;
import org.mahiiru.domain.models.Sale;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilesManager {

    private final String pathBooks;
    private final String pathClients;
    private final String pathSales;
    private final String txt;

    public FilesManager() {
        pathBooks = Resources.PATH_FILE_BOOKS;
        pathClients = Resources.PATH_FILE_CLIENTS;
        pathSales = Resources.PATH_PACKAGE_SALES;
        txt = Resources.TXT;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathBooks));
            String line;
            while ((line = reader.readLine()) != null){
                String[] bookLine = line.split(",");
                Book newBook = new Book(
                        bookLine[0],
                        bookLine[1],
                        bookLine[2],
                        bookLine[3],
                        Integer.parseInt(bookLine[4]),
                        Integer.parseInt(bookLine[5])
                );
                books.add(newBook);
            }
            reader.close();
        }catch (IOException e){
            System.err.println("Error al cargar los libros : " + e.getMessage());
        }
        return books;
    }

    public void putBooks(HashMap<Integer,Book> booksStock) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathBooks));
            booksStock.forEach(
                    (id,book) ->
                    {
                        try {
                            writer.write(
                                    book.getBookID() + "," +
                                            book.getTitle() + "," +
                                            book.getAuthors() + "," +
                                            book.getIsbn() + "," +
                                            book.getStock() + "," +
                                            book.getPrice() + "\n"
                            );
                        } catch (IOException e) {
                            System.err.println("Error al guardar el libro " + book + " : " + e.getMessage());
                        }
                    }
            );
            writer.flush(); // asegurarse de que se escriban los datos en el archivo
            writer.close(); // cerrar el BufferedWriter
            System.out.println("Archivo books.txt actualizado.");
        }catch (IOException e){
            System.err.println("Error al actualizar el stock de libros : " + e.getMessage());
        }
    }

    public List<String> getClients() {
        List<String> clientLines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathClients));
            String line;
            while ((line = reader.readLine()) != null) {
                clientLines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al cargar los clientes: " + e.getMessage());
        }
        return clientLines;
    }

    public void postClients(HashMap<String, Client> clients){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathClients));
            clients.forEach(
                    (email,client) ->
                    {
                        try {
                            writer.write(client.getName() + "," + client.getEmail() + "\n");
                        } catch (IOException e) {
                            System.err.println("Error al guardar el cliente " + client + " : " + e.getMessage());
                        }
                    }
            );
            writer.flush(); // asegurarse de que se escriban los datos en el archivo
            writer.close(); // cerrar el BufferedWriter
            System.out.println("Archivo Clients.txt actualizado.");
        }catch (IOException e){
            System.err.println("Error al guardar los clientes : " + e.getMessage());
        }
    }

    public String[] getSales() {
        File f = new File(this.pathSales);
        String[] files = f.list();
        return files;
    }

    public void getSale(String saleFile){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathSales + saleFile));
            String line;
            System.out.println("=== MOSTRANDO ARCHIVO SALE ===");
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
            System.out.println("=== MOSTRANDO ARCHIVO SALE ===\n");
        }catch (IOException e){
            System.err.println("Error al cargar el archivo sale : " + e.getMessage());
        }
    }

    public void postSale(Sale sale){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathSales + sale.getId() + txt));
            System.out.println("Writer creado");
            writer.write(sale.toString());
            System.out.println("Write hecho");
            writer.flush(); // asegurarse de que se escriban los datos en el archivo
            writer.close(); // cerrar el BufferedWriter
            System.out.println("Archivo sale creado.");
        }catch (IOException e){
            System.err.println("Error al guardar la venta : " + e.getMessage());
        }
    }

}
