package ConfigurationJSON.KnowledgeBuilder;

import java.util.ArrayList;
import java.util.List;

public class CompositeTypeDTO extends ProductTypeDTO{

    private List<ProductTypeDTO> children;

    public CompositeTypeDTO(){}

    public void setChildren(List<ProductTypeDTO> children) {
        this.children = new ArrayList<>(children);
    }

    public List<ProductTypeDTO> getChildren() {
        return children;
    }
}
