package Optimization.Builder;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import Controller.Controller;
import Knowledge.Catalogs.ProductCatalog;
import Operational.OrderManager.Order;
import Optimization.Model.Node;
import Optimization.Model.OptimizationProblem;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class OptimizationProblemBuilderTest {

    private static final ProductCatalog productCatalog = ProductCatalog.getInstance();

    @Before
    public void setup() {
        Controller.getInstance().reset();
    }

    @BeforeClass
    public static void setUpProductCatalog() throws IOException {
        Configuration config = new Configuration();
        productCatalog.addProductType(new TypeBuilder().buildProductListType(config.readProductListJSON("/ProductCatalog.json")));
    }

    @Test
    public void buildMatrixNodesTest() throws IOException {

        Controller controller = Controller.getInstance();
        controller.addOrder("/Orders/Order.json");
        controller.addOrder("/Orders/Order2.json");
        controller.addOrder("/Orders/Order3.json");
        controller.addOrder("/Orders/Order4.json");
        controller.addOrder("/Orders/Order5.json");
        List<Order> orders = controller.getOrderList();
        OptimizationProblemBuilder opb = new OptimizationProblemBuilder(orders);
        OptimizationProblem op = opb.buildOptimizationProblem();

        for(Node n : op.getNodes())
            n.setProductionTime(60 * 10);

        int i = 0;
        while (i < op.getCm().getDimension()){
            assertEquals(0, op.getCm().getCost(i, i));
            i++;
        }

        assertEquals(20, op.getCm().getCost(0, 1));
        assertEquals(50, op.getCm().getCost(0, 2));
        assertEquals(60, op.getCm().getCost(1, 2));
    }
}
