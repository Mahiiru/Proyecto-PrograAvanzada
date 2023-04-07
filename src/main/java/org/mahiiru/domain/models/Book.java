package org.mahiiru.domain.models;

public class Book {
    private String bookID;
    private String title;
    private String authors;
    private String isbn;
    private int stock;
    private int price;

    public Book(String bookID, String title, String authors, String isbn, int stock, int price) {
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.stock = stock;
        this.price = price;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{\n" +
                "bookID= \n'" + bookID + '\'' +
                "\ntitle= \n'" + title + '\'' +
                "\nauthors= \n'" + authors + '\'' +
                "\nisbn= \n'" + isbn + '\'' +
                "\nprice= \n" + price + "\n" +
                '}';
    }
}
