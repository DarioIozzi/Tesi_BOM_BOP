package Knowledge;

import java.util.HashMap;
import java.util.Map;

public class CompositeType extends ProductType{
    private final Map<Integer, ProductType> children = new HashMap<>();      //TODO mettere un id ai composite? come accedo ad un composite in un composite altrimenti?

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
        if (pt instanceof ElementType) {        //TODO posso aggiungere solo elementi o altri composite?
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
