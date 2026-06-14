package Controller;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import ConfigurationJSON.OperationalBuilder.FeatureDTO;
import ConfigurationJSON.OperationalBuilder.ObservationDTO;
import ConfigurationJSON.OperationalBuilder.OpBuilder;
import ConfigurationJSON.OperationalBuilder.UnitDTO;
import Knowledge.Catalogs.ProductCatalog;
import Knowledge.FeatureType;
import Knowledge.ObservationType;
import Knowledge.ProductType;
import Knowledge.UnitType;
import Operational.*;
import Operational.OrderManager.Order;
import Operational.OrderManager.OrderManager;
import Operational.Process;
import Optimization.Builder.OptimizationProblemBuilder;
import Optimization.Model.OptimizationProblem;
import Optimization.Solver.OrToolsSolver;
import Optimization.Solver.Solver;
import Warehouse.Warehouse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

    public void removeProductType(String code) {
        productCatalog.removeProductType(code);
    }

    public Collection<ProductType> getProductCatalog(){
        return productCatalog.getProductTypes();
    }

    public Collection<ProductType> getChildrenProductCatalog(){
        return productCatalog.getChildren();
    }

    public ProductType getProductType(String code){
        return productCatalog.getProductType(code);
    }

    //Resource-warehouse methods

    public void addResourceToWarehouse(String path) throws IOException {
        Configuration config = new Configuration();
        warehouse.addResource(new OpBuilder().buildResource(config.readResourceJSON(path)));
    }

    public void removeResourceFromWarehouse(String family, int resourceId) {
        warehouse.removeResource(family, resourceId);
    }

    public void displayWarehouse() {
        warehouse.display();
    }

    public Map<String, Map<Integer, Resource>> getWarehouse(){
        return warehouse.getResources();
    }

    //Resource-product methods

    public void addResourceToProduct(int orderId, String code, int resourceId, String family) {
        ((Element) orderManager.getOrder(orderId).getProduct(code)).setResource(warehouse.getResource(family, resourceId));
    }

    public void removeResourceFromProduct(int orderId, String code) {
        ((Element) orderManager.getOrder(orderId).getProduct(code)).removeResource();
    }


    //Observations-Product methods

    public void addObservation(int orderId, String code, String path) throws IOException {
        Configuration config = new Configuration();
        Process p = orderManager.getOrder(orderId).getProduct(code).getProcess();
        ObservationDTO ob = config.readObservationJSON(path);
        ObservationType obt = p.getType().getObservationType(ob.getCode());
        if(obt == null)
            throw new RuntimeException("ObservationType not found");

        Observation o = new OpBuilder().buildObservation(ob);
        o.setType(obt);
        p.addObservation(o);
    }

    public void removeObservation(int orderId, String code, int observationId){
        orderManager.getOrder(orderId).getProduct(code).getProcess().removeObservaion(observationId);
    }

    public void modifyStatusProcess(int orderId, String code, int status){
        if(status == 1)
            orderManager.getOrder(orderId).getProduct(code).getProcess().completed();
        else if(status == 2)
            orderManager.getOrder(orderId).getProduct(code).getProcess().failed();
    }

    //Feature-Product methods

    public void addFeature(int orderId, String code, String path) throws IOException {
        Configuration config = new Configuration();
        Product p = orderManager.getOrder(orderId).getProduct(code);
        FeatureDTO fd = config.readFeatureJSON(path);
        FeatureType ft = p.getType().getFeatureType(fd.getType());
        if (ft == null)
            throw new RuntimeException("Feature type not found");

        List<UnitType> uts = ft.getUnitTypes();
        boolean found;
        for(UnitDTO u : fd.getUnits()){
            found = false;
            for (UnitType ut : uts)
                if (ut.getCode().equals(u.getUnitCode())) {
                    found = true;
                    break;
                }

            if(!found)
                throw new IOException("Units are not valid");
        }
        List<Unit> us = new OpBuilder().buildUnits(fd.getUnits(), uts);
        Feature f = new OpBuilder().buildFeature(fd, us);
        f.setType(ft);
        p.addFeature(f);
    }

    public void removeFeature(int orderId, String code, int featureId){
        orderManager.getOrder(orderId).getProduct(code).removeFeature(featureId);
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

    public List<Order> getOrderList(){
        return orderManager.getOrders();
    }

    private List<Order> orderToOptimize(int days) {

        List<Order> orders = new ArrayList<>(orderManager.getOrders());

        orders.removeIf(order -> {
            long remainingDays = ChronoUnit.DAYS.between(LocalDate.now(), order.getDeadline());

            return remainingDays < 0 || remainingDays > days || order.getStatus() != Order.Status.READY;
        });

        return orders;
    }

    public void optimize(int days){
        OptimizationProblem op = new OptimizationProblemBuilder(this.orderToOptimize(days)).buildOptimizationProblem();
        Solver ots = new OrToolsSolver();
        ots.solve(op);
    }
}
