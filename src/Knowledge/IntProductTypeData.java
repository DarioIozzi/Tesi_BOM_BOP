package Knowledge;

import java.util.Objects;

public class IntProductTypeData {

    private int quantity;
    private ProductType productType;

    public IntProductTypeData(int quantity, ProductType productType) {
        if(quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");
        if(productType == null)
            throw new IllegalArgumentException("Product cannot be null");
        this.quantity = quantity;
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void modifyQuantity(int quantity) {
        this.quantity += quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof IntProductTypeData)) return false;
        IntProductTypeData other = (IntProductTypeData) obj;
        return quantity == other.getQuantity() && productType == other.getProductType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, productType);
    }
}
