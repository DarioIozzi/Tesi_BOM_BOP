import ConfigurationJSON.Configuration;
import ConfigurationJSON.TypeBuilder;
import Knowledge.ProcessType;
import Knowledge.ProductType;
import Knowledge.ResourceType;

import java.io.IOException;

public class Controller {

    private final Warehouse warehouse;

    public Controller(){
        warehouse = new Warehouse();
    }

    public void addProcessType() throws IOException {
        Configuration config = new Configuration();
        ProcessType pt = new TypeBuilder(config.readProcessJSON("/Process.json")).buildProcessType();
    }

    public void addProductType() throws IOException {
        Configuration config = new Configuration();
        ProductType pt = new TypeBuilder(config.readProductJSON("/Product.json")).buildProductType();
    }

    public void addResourceType() throws IOException {
        Configuration config = new Configuration();
        ResourceType rt = new TypeBuilder(config.readResourceJSON("/Resource.json")).buildResourceType();
    }

    public void addProcess(){}

    public void addElement(){}

    public void addResource(){}

    public void addUnit(){}

    public void addOrder(){}
}
