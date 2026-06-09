package Optimization.Solver;

import ConfigurationJSON.Configuration;
import ConfigurationJSON.KnowledgeBuilder.TypeBuilder;
import Controller.Controller;
import Knowledge.Catalogs.ProductCatalog;
import Operational.OrderManager.Order;
import Optimization.Builder.OptimizationProblemBuilder;
import Optimization.Model.OptimizationProblem;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class OrToolsSolverTest {

    @Test
    public void OrToolsSolverTest() throws IOException {

        Configuration config = new Configuration();
        ProductCatalog productCatalog = ProductCatalog.getInstance();
        productCatalog.addProductType(new TypeBuilder().buildProductListType(config.readProductListJSON("/ProductCatalog.json")));
        Controller.getInstance().reset();
        Controller controller = Controller.getInstance();

        controller.addOrder("/Orders/Order.json");
        controller.addOrder("/Orders/Order2.json");
        controller.addOrder("/Orders/Order3.json");
        controller.addOrder("/Orders/Order4.json");
        controller.addOrder("/Orders/Order5.json");
        List<Order> orders = controller.getOrderList();
        OptimizationProblemBuilder opb = new OptimizationProblemBuilder(orders);
        OptimizationProblem op = opb.buildOptimizationProblem();
        OrToolsSolver solver = new OrToolsSolver();
        solver.solve(op);
    }
}
