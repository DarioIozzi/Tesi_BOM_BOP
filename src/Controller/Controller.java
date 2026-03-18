package Controller;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import ConfigurationJSON.OperationalBuilder.OpBuilder;
import Knowledge.ProductCatalog.ProductCatalog;
import Knowledge.ProductType;
import Operational.Element;
import Operational.OrderManager.Order;
import Operational.OrderManager.OrderManager;
import Operational.Resource;
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
        productCatalog = ProductCatalog.getInstance();
        orderManager = new OrderManager();
    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }

        return instance;
    }

    public void reset(){        //Per testing
        warehouse.reset();
        orderManager.reset();
    }

    //Product Types methods

    public void addProductType(String path) throws IOException {
        Configuration config = new Configuration();
        ProductType pt = new TypeBuilder().buildProductType(config.readProductJSON(path));
        productCatalog.addProductType(pt);
    }

    public void addProductTypeList(String path) throws IOException {
        Configuration config = new Configuration();
        List<ProductType> pt = new TypeBuilder().buildProductListType(config.readProductListJSON(path));
        productCatalog.addProductType(pt);
    }

    public void removeProductType(int id) {
        productCatalog.removeProductType(id);
    }

    public Collection<ProductType> getProductCatalog(){
        return productCatalog.getProductTypes();
    }

    public ProductType getProductType(int id){
        return productCatalog.getProductType(id);
    }

    //Resource-product methods

    public void addResourceToProduct(int orderId, int productId, int resourceId, int family) {
        ((Element) orderManager.getOrder(orderId).getProduct(productId)).setResource(warehouse.getResource(family, resourceId));
    }

    public void removeResourceFromProduct(int orderId, int productId) {
        ((Element) orderManager.getOrder(orderId).getProduct(productId)).removeResource();
    }


    //Observations-Product methods

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

    //Feature-Product methods

    public void addFeature(int orderId, int productId) throws IOException {
        Configuration config = new Configuration();
        orderManager.getOrder(orderId).getProduct(productId).addFeature(new OpBuilder().buildFeature(config.readFeatureJSON("/Feature")));
    }

    public void removeFeature(int orderId, int productId, int featureId){
        orderManager.getOrder(orderId).getProduct(productId).removeFeature(featureId);
    }

    //Resource-warehouse methods

    public void addResourceToWarehouse(String path) throws IOException {
        Configuration config = new Configuration();
        warehouse.addResource(new OpBuilder().buildResource(config.readResourceJSON(path)));
    }

    public void removeResourceFromWarehouse(int family, int resourceId) {
        warehouse.removeResource(family, resourceId);
    }

    public void displayWarehouse() {
        warehouse.display();
    }

    public Map<Integer, Map<Integer, Resource>> getWarehouse(){
        return warehouse.getResources();
    }

    //Order methods

    public void addOrder(String path) throws IOException {
        Configuration config = new Configuration();
        orderManager.addOrder(new OpBuilder().buildOrder(config.readOrderJSON(path)));
    }

    public void removeOrder(int orderId){
        orderManager.removeOrder(orderId);
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

    public List<Order> displayOrderList(){
        return orderManager.getOrders();
    }
}
