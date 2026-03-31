package ConfigurationJSON.KnowledgeBuilder;

import java.util.ArrayList;
import java.util.List;

public class CompositeTypeDTO extends ProductTypeDTO{

    private List<RequirementTypeDTO> children;

    public CompositeTypeDTO(){}

    public void setChildren(List<RequirementTypeDTO> children) {
        this.children = new ArrayList<>(children);
    }

    public List<RequirementTypeDTO> getChildren() {
        return children;
    }
}
