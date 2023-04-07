package org.mahiiru.domain.models;



public class SaleDetails {

    private Book book;
    private int quantity;
    private int totalAmount;

    public SaleDetails(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.totalAmount = getTotalAmountFromBook();
    }

    private int getTotalAmountFromBook() {
        return this.book.getPrice() * this.quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "SaleDetails{\n" +
                "book= \n" + book +
                "\nquantity= \n" + quantity +
                "\ntotalAmount= \n" + totalAmount + "\n" +
                '}';
    }
}
