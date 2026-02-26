package Knowledge;

public abstract class ProductType {

    public void addProductType(ProductType pt){
        throw new UnsupportedOperationException("Not a compositeType");
    }

    public boolean removeProductType(int id){
        throw new UnsupportedOperationException("Not a compositeType");
    }

    public ProductType getChild(int id) {
        return null;
    }

    public abstract int getId();

    public abstract boolean isThere(FeatureType ft);
}
