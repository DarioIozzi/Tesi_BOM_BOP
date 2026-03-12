package ConfigurationJSON.KnowledgeBuilder;

import Others.IntProductTypeData;

import java.util.ArrayList;
import java.util.List;

public class CompositeTypeDTO extends ProductTypeDTO{

    private List<IntProductTypeDataDTO> children;

    public CompositeTypeDTO(){}

    public void setChildren(List<IntProductTypeDataDTO> children) {
        this.children = new ArrayList<>(children);
    }

    public List<IntProductTypeDataDTO> getChildren() {
        return children;
    }
}
