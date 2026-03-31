package ConfigurationJSON.OperationalBuilder;

public class RequirementDTO {

    private int quantity;
    private ProductDTO product;

    public RequirementDTO(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
