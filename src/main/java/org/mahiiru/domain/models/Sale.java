package org.mahiiru.domain.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Sale {

    private Client client;
    private List<SaleDetails> details;
    private int total;

    private LocalDateTime dateTime;
    private String id;

    public Sale(Client client, List<SaleDetails> details) {
        this.client = client;
        this.details = details;
        this.total = getTotalFromDetails();
        this.dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm:ss");
        this.id = this.dateTime.format(formatter) + "/" + this.client.getEmail();
    }

    private int getTotalFromDetails() {
        return this.details
                .stream()
                .mapToInt(SaleDetails::getTotalAmount)
                .sum();
    }

    public Client getClient() {
        return client;
    }

    public List<SaleDetails> getDetails() {
        return details;
    }

    public int getTotal() {
        return total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sale{\n" +
                "client= \n" + client +
                "\ndetails= \n" + details +
                "\ntotal= \n" + total +
                "\ndateTime= \n" + dateTime +
                "\nid= \n'" + id + '\'' + "\n" +
                '}';
    }
}
