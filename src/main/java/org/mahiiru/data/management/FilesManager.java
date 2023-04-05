package org.mahiiru.data.management;

import org.mahiiru.common.Resources;
import org.mahiiru.domain.models.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {

    private final String pathBooks;

    public FilesManager() {
        pathBooks = Resources.PATH_FILE_BOOKS;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathBooks));
            String line;
            while ((line = reader.readLine()) != null){
                String[] bookLine = line.replace("\"", "").split(",");
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
}
