package Operational;

import Knowledge.ProcessType;

import java.util.ArrayList;
import java.util.List;

public class Process {

    private static int counter = 0;
    private final int id;
    private ProcessType type;
    private List<Product> products = new ArrayList<>();             //TODO da definire
    private Resource resource;

    public Process(ProcessType type, Resource resource) {
        this.id = counter++;
        this.type = type;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public ProcessType getType() {
        return type;
    }

    public void setType(ProcessType type) {
        this.type = type;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public Resource getResource(){
        return resource;
    }

    public void setResource(Resource resource){
        this.resource = resource;
    }
}
