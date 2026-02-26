package Knowledge;

import java.util.HashMap;
import java.util.Map;

public class CompositeType extends ProductType{
    private Map<Integer, ProductType> children = new HashMap<>();

    @Override
    public int getId(){
        throw new UnsupportedOperationException("Not an elementType");
    }

    @Override
    public boolean isThere(FeatureType ft){
        throw new UnsupportedOperationException("Not an elementType");
    }

    @Override
    public void addProductType(ProductType pt) {
        if (pt instanceof ElementType) {
            children.put(pt.getId(), pt);
        }
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
