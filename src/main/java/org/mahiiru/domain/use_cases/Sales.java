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
        IntStream.range(0, this.sales.size())
                .forEach(i -> System.out.println(i + ": " + this.sales.get(i)));
    }

    public void getSaleByIndex(int index){
        manager.getSale(this.sales.get(index));
    }

    public void postSale(Client client, List<SaleDetails> details){
        Sale sale = new Sale(client,details);
        manager.postSale(sale);
    }
}
