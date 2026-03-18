package Controller;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import Knowledge.ProductCatalog.ProductCatalog;
import Knowledge.ProductType;
import static org.junit.Assert.*;

import Operational.Resource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class ControllerTest {

    private Controller controller;
    private static ProductCatalog catalog = new ProductCatalog();

    @Before
    public void setup() {
        Controller.getInstance().reset();
        controller = Controller.getInstance();
    }

    @BeforeClass
    public static void setUpProductCatalog() throws IOException {
        Configuration config = new Configuration();
        catalog.addProductType(new TypeBuilder().buildProductListType(config.readProductListJSON("/ProductCatalog.json")));
    }

    @Test
    public void productsTypeMethodsTest() throws IOException {

        //Add single
        int before = controller.getProductCatalog().size();
        controller.addProductType("/Product.json");
        ProductType added = catalog.getProductTypes().stream().filter(p -> p.getFamily().equals("Dining Chair")).findFirst().orElse(null);
        assertNotNull(added);
        assertEquals(before + 1, controller.getProductCatalog().size());

        //Remove
        ProductType toRemove = catalog.getProductTypes().stream().filter(p -> p.getFamily().equals("Dining Table")).findFirst().orElseThrow();
        controller.removeProductType(toRemove.getId());
        assertEquals(before, controller.getProductCatalog().size());

        //List
        controller.addProductTypeList("/MoreProducts.json");
        assertEquals(before + 2, controller.getProductCatalog().size());
        added = catalog.getProductTypes().stream().filter(p -> p.getFamily().equals("Bench")).findFirst().orElse(null);
        assertNotNull(added);
        added = catalog.getProductTypes().stream().filter(p -> p.getFamily().equals("Shoe Cabinet")).findFirst().orElse(null);
        assertNotNull(added);
    }

    @Test
    public void resourceToWarehouseMethodsTest() throws IOException {

        //Add
        controller.addResourceToWarehouse("/Resource.json");
        assertEquals(1, controller.getWarehouse().size());
        Resource r = controller.getWarehouse().get(0).get(0);
        assertNotNull(r);

        //Remove
        controller.removeResourceFromWarehouse(0, 0);
        assertEquals(0, controller.getWarehouse().size());
    }

    @Test
    public void orderMethodsTest() throws IOException {

        controller.addOrder("/Resource.json");      //TODO finire
    }
}
