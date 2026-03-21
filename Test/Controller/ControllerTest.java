package Controller;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import Knowledge.Catalogs.ProductCatalog;
import Knowledge.Catalogs.ResourceCatalog;
import Knowledge.ProductType;
import static org.junit.Assert.*;

import Operational.*;
import Operational.OrderManager.Order;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ControllerTest {

    private Controller controller;
    private static final ProductCatalog productCatalog = ProductCatalog.getInstance();
    private static final ResourceCatalog resourceCatalog = ResourceCatalog.getInstance();

    @Before
    public void setup() {
        Controller.getInstance().reset();
        controller = Controller.getInstance();
    }

    @BeforeClass
    public static void setUpProductCatalog() throws IOException {
        Configuration config = new Configuration();
        productCatalog.addProductType(new TypeBuilder().buildProductListType(config.readProductListJSON("/ProductCatalog.json")));
    }

    @Test
    public void productsTypeMethodsTest() throws IOException {

        //Add single
        int before = controller.getProductCatalog().size();
        controller.addProductType("/ProductType.json");
        ProductType added = productCatalog.getProductType("DC-001");
        assertNotNull(added);
        assertEquals(before + 1, controller.getProductCatalog().size());

        //Remove
        ProductType toRemove = productCatalog.getProductType("DC-001");
        controller.removeProductType(toRemove.getCode());
        assertEquals(before, controller.getProductCatalog().size());

        //List
        controller.addProductTypeList("/MoreProductTypes.json");
        assertEquals(before + 2, controller.getProductCatalog().size());
        added = productCatalog.getProductTypes().stream().filter(p -> p.getFamily().equals("Bench")).findFirst().orElse(null);
        assertNotNull(added);
        added = productCatalog.getProductTypes().stream().filter(p -> p.getFamily().equals("Shoe Cabinet")).findFirst().orElse(null);
        assertNotNull(added);
    }

    @Test
    public void resourceToWarehouseMethodsTest() throws IOException {

        //Add
        controller.addResourceToWarehouse("/Resource.json");
        assertEquals(1, controller.getWarehouse().size());
        Resource r = controller.getWarehouse().get("WoodBeam").get(0);
        assertNotNull(r);

        //Remove
        controller.removeResourceFromWarehouse("WoodBeam", 0);
        assertEquals(1, controller.getWarehouse().size());
        assertEquals(0, controller.getWarehouse().get("WoodBeam").size());
    }

    @Test
    public void orderMethodsTest() throws IOException {

        //Manage orders and order status
        controller.addOrder("/Order.json");
        Order o = controller.getOrderList().get(0);
        assertEquals(1, controller.getOrderList().size());
        assertEquals(Order.Status.READY, o.getStatus());
        controller.startOrder(o.getId());
        assertEquals(Order.Status.IN_PROGRESS, o.getStatus());
        controller.closeOrder(o.getId(), 1);
        assertEquals(Order.Status.COMPLETE, o.getStatus());
        controller.closeOrder(o.getId(), 2);
        assertEquals(Order.Status.FAILED, o.getStatus());
        controller.removeOrder(o.getId());
        assertEquals(0, controller.getOrderList().size());

        controller.addOrder("/Order.json");

        //Manage product resources
        controller.addResourceToWarehouse("/Resource.json");
        assertEquals(1, controller.getWarehouse().size());
        Resource r = controller.getWarehouse().get(0).get(0);
        controller.addOrder("/Order.json");
        o = controller.getOrderList().get(0);
        Product p = o.getProduct("TL-001");
        controller.addResourceToProduct(o.getId(), p.getType().getCode(), r.getId(), r.getFamily());
        assertEquals(r.getLotto(), ((Element)p).getResource().getLotto());
        assertEquals(r.getLotto(), ((Element)p).getResource().getLotto());
        controller.removeResourceFromProduct(o.getId(), p.getType().getCode());

        //Manage process observations
        controller.addObservation(o.getId(), p.getType().getCode(), "/Observation.json");
        List<Observation> obs = o.getProduct(p.getType().getCode()).getProcess().getObservations();
        assertEquals(1, obs.size());
        assertEquals(obs.get(0).getText(), "");
        controller.removeObservation(o.getId(), p.getType().getCode(), obs.get(0).getId());
        assertEquals(1, o.getProduct(p.getType().getCode()).getProcess().getObservations().size());

        //Manage product features
        controller.addFeature(o.getId(), p.getType().getCode(), "/Feature.json");
        List<Feature> fs = o.getProduct(p.getType().getCode()).getFeatures();
        assertEquals(1, fs.size());
        assertEquals(2, fs.get(0).getUnits().size());
        controller.removeFeature(o.getId(), p.getType().getCode(), fs.get(0).getId());
        assertEquals(0, o.getProduct(p.getType().getCode()).getFeatures().size());
    }
}
