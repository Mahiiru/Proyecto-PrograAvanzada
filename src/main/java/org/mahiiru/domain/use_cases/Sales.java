package org.mahiiru.domain.use_cases;

import org.mahiiru.data.management.FilesManager;
import org.mahiiru.domain.models.Client;
import org.mahiiru.domain.models.Sale;
import org.mahiiru.domain.models.SaleDetails;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Sales {

    private List<String> sales;
    private FilesManager manager;

    public Sales() {
        this.manager = new FilesManager();
        this.sales = getSalesFiles();
    }

    private List<String> getSalesFiles() {
        return Arrays.stream(manager.getSales()).toList();
    }

    public void getSales(){
        this.sales.forEach(System.out::println);
    }

    public void getSaleByID(String id){
        manager.getSale(id);
    }

    public void postSale(Client client, List<SaleDetails> details){
        Sale sale = new Sale(client,details);
        manager.postSale(sale);
    }
}
