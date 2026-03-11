package Knowledge;

import java.util.*;

public class CompositeType extends ProductType{

    private final List<ProductType> children;

    public CompositeType(ProcessType pt, String family, List<FeatureType> ft, List<ProductType> children) {

        super(pt, family, ft);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
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
        children.add(pt.getId(), pt);
    }

    @Override
    public boolean removeProductType(int id){
        return children.remove(id) != null;
    }

    @Override
    public ProductType getChild(int i) {                //TODO ??
        return children.get(i);
    }

    public List<ProductType> getChildren(){
        return children;
    }
}
