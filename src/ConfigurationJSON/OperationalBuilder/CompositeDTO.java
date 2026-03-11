package ConfigurationJSON.OperationalBuilder;

import Operational.Product;

import java.util.List;

public class CompositeDTO extends ProductDTO{

    private List<Product> children;

    public CompositeDTO() {}

    public void setChildren(List<Product> children) {
        this.children = children;
    }

    public List<Product> getChildren() {
        return children;
    }
}
