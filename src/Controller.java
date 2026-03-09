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
        ProcessType pt = new TypeBuilder().buildProcessType(config.readProcessJSON("/Process.json"));
    }

    public void addProductType() throws IOException {
        Configuration config = new Configuration();
        ProductType pt = new TypeBuilder().buildProductType(config.readProductJSON("/Product.json"));
    }

    public void addResourceType() throws IOException {
        Configuration config = new Configuration();
        ResourceType rt = new TypeBuilder().buildResourceType(config.readResourceJSON("/Resource.json"));
    }

    public void addProcess(){}

    public void addElement(){}

    public void addResource(){}

    public void addOrder(){}
}
