package ConfigurationJSON;

import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import ConfigurationJSON.OperationalBuilder.OpBuilder;
import Knowledge.Catalogs.ProductCatalog;
import Operational.IntProductData;
import Operational.OrderManager.Order;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

public class OpBuilderTest {

    @Test
    public void testOrderProductBuilder() throws IOException {
        Configuration config = new Configuration();
        OpBuilder opBuilder = new OpBuilder();
        ProductCatalog pc = ProductCatalog.getInstance();
        pc.addProductType(new TypeBuilder().buildProductListType(config.readProductListJSON("/ProductCatalog.json")));
        Order o = opBuilder.buildOrder(config.readOrderJSON("/Order.json"));
        assertEquals(2, o.getProductslist().size());
        List<IntProductData> products = o.getProductslist();
        assertEquals(2, products.get(0).getQuantity());
        assertEquals(5, products.get(1).getQuantity());
        assertEquals("DT-001", products.get(0).getProduct().getType().getCode());
        assertEquals("CT-001", products.get(1).getProduct().getType().getCode());
        assertEquals(2, products.get(0).getProduct().getChildren().size());
        assertEquals(2, products.get(1).getProduct().getChildren().size());
    }
}
