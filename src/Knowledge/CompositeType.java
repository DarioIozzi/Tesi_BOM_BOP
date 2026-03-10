package Knowledge;

import java.util.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeType extends ProductType{

    private final Map<Integer, ProductType> children;

    public CompositeType(ProcessType pt, String family, List<FeatureType> ft, Map<Integer, ProductType> children) {

        super(pt, family, ft);
        this.children = new HashMap<>(Objects.requireNonNull(children, "children cannot be null"));
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public boolean isThere(FeatureType ft){
        throw new UnsupportedOperationException("Not an elementType");          //TODO
    }

    @Override
    public void addProductType(ProductType pt) {
        children.put(pt.getId(), pt);
    }

    @Override
    public boolean removeProductType(int id){
        return children.remove(id) != null;
    }

    @Override
    public ProductType getChild(int id) {
        return children.get(id);
    }
}
