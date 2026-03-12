package ConfigurationJSON.KnowledgeBuilder;

public class IntProductTypeDataDTO {

    private int quantity;
    private ProductTypeDTO productType;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public ProductTypeDTO getProductType() {
        return productType;
    }
}
