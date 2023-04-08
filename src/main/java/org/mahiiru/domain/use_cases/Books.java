package org.mahiiru.domain.use_cases;

import org.mahiiru.data.management.FilesManager;
import org.mahiiru.domain.models.Book;
import org.mahiiru.domain.models.SaleDetails;

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

    public Book getBookByID(int id){return this.booksStock.get(id);}

    public SaleDetails getSaleByIDAndNumBooks(int id, int numBooks){
        //Aqui deberia agregarse logica para restar del stock el num de libros
        return new SaleDetails(getBookByID(id),numBooks);
    }

    @Override
    public String toString() {
        return "Books{" +
                "booksStock=" + booksStock +
                '}';
    }
}
