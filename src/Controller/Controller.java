package Controller;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import ConfigurationJSON.OperationalBuilder.OpBuilder;
import Knowledge.ProductCatalog.ProductCatalog;
import Knowledge.ProductType;
import Operational.Element;
import Operational.OrderManager.OrderManager;
import Warehouse.Warehouse;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Controller {

    private static Controller instance = null;
    private final Warehouse warehouse;
    private final ProductCatalog productCatalog;
    private final OrderManager orderManager;

    private Controller(){
        warehouse = new Warehouse();
        productCatalog = new ProductCatalog();
        orderManager = new OrderManager();
    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }

        return instance;
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

    public void addResourceToProduct(int orderId, int productId, int resourceId, int family) {
        ((Element) orderManager.getOrder(orderId).getProduct(productId)).setResource(warehouse.getResource(family, resourceId));
    }

    public void removeResourceFromProduct(int orderId, int productId) {
        ((Element) orderManager.getOrder(orderId).getProduct(productId)).removeResource();
    }

    public void addResourceToWarehouse() throws IOException {
        Configuration config = new Configuration();
        warehouse.addResource(new OpBuilder().buildResource(config.readResourceJSON("/Resource.json")));
    }

    public void removeResourceFromWarehouse(int family, int resourceId) {
        warehouse.removeResource(family, resourceId);
    }

    public void displayWarehouse() {
        warehouse.display();
    }

    public void addOrder() throws IOException {
        Configuration config = new Configuration();
        orderManager.addOrder(new OpBuilder().buildOrder(config.readOrderJSON("/Order.json")));
    }

    public Collection<ProductType> displayProductCatalog(){
        return productCatalog.getProductTypes();
    }

    public void addObservation(int orderId, int productId) throws IOException {
        Configuration config = new Configuration();
        orderManager.getOrder(orderId).getProduct(productId).getProcess().addObservation(new OpBuilder().buildObservation(config.readObservationJSON("/Observation")));
    }

    public void removeObservation(int orderId, int productId, int observationId){
        orderManager.getOrder(orderId).getProduct(productId).getProcess().removeObservaion(observationId);
    }

    public void modifyStatusProcess(int orderId, int productId, int status){
        if(status == 1)
            orderManager.getOrder(orderId).getProduct(productId).getProcess().completed();
        else if(status == 2)
            orderManager.getOrder(orderId).getProduct(productId).getProcess().failed();
    }

    public void startOrder(int orderId){
        orderManager.getOrder(orderId).start();
    }

    public void closeOrder(int orderId, int res){
        if (res == 1)
            orderManager.getOrder(orderId).complete();
        else if(res == 2)
            orderManager.getOrder(orderId).failed();
    }

    public void displayOrder(int id){
        System.out.println(orderManager.getOrder(id).getProductslist());
    }

    public void addFeature(int orderId, int productId) throws IOException {
        Configuration config = new Configuration();
        orderManager.getOrder(orderId).getProduct(productId).addFeature(new OpBuilder().buildFeature(config.readFeatureJSON("/Feature")));
    }

    public void removeFeature(int orderId, int productId, int featureId){
        orderManager.getOrder(orderId).getProduct(productId).removeFeature(featureId);
    }
}
