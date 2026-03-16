package Controller;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import ConfigurationJSON.OperationalBuilder.OpBuilder;
import Knowledge.ProductCatalog;
import Knowledge.ProductType;
import Operational.Order;
import Warehouse.Warehouse;

import java.io.IOException;
import java.util.List;

public class Controller {

    private final Warehouse warehouse;
    private final ProductCatalog productCatalog;

    public Controller(){
        warehouse = new Warehouse();
        productCatalog = new ProductCatalog();
    }

    public void addProductType() throws IOException {
        Configuration config = new Configuration();
        ProductType pt = new TypeBuilder().buildProductType(config.readProductJSON("/Product.json"));
        productCatalog.addProductType(pt);
    }

    public void addProductTypeList() throws IOException {
        Configuration config = new Configuration();
        List<ProductType> pt = new TypeBuilder().buildProductListType(config.readProductListJSON("/ProductCatalog.json"));
        productCatalog.addProductType(pt);
    }

    public void removeProductType(int id) {
        productCatalog.removeProductType(id);
    }

    public void addResource() throws IOException{
        Configuration config = new Configuration();
        warehouse.addResource(new OpBuilder().buildResource(config.readResourceJSON("/Resource.json")));
    }

    public void addOrder() throws IOException {             //TODO menù gestione ordine --> aggiunta di features, observations, modifica stato processi (?)
        Configuration config = new Configuration();
        Order order = new OpBuilder().buildOrder(config.readOrderJSON("/Order.json"));
    }
}
