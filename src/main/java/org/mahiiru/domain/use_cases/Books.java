package org.mahiiru.domain.use_cases;

import org.mahiiru.data.management.FilesManager;
import org.mahiiru.domain.models.Book;

import java.util.HashMap;

public class Books {

    private HashMap<Integer, Book> booksStock;
    private final FilesManager manager;

    public Books() {
        this.manager = new FilesManager();
        this.booksStock = getBooks();
    }

    private HashMap<Integer, Book> getBooks() {
        HashMap<Integer,Book> books = new HashMap<>();
        manager.getBooks().forEach(
                (Book b) -> books.put(Integer.parseInt(b.getBookID()),b)
        );
        return books;
    }

    public void getBooksStock() {
        this.booksStock.forEach((id,book) -> System.out.println(id + ")." + "\n" + book.toString()));
    }

    @Override
    public String toString() {
        return "Books{" +
                "booksStock=" + booksStock +
                '}';
    }
}
