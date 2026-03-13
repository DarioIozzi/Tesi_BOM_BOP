package ConfigurationJSON.OperationalBuilder;

public class IntProductDataDTO {

    private int quantity;
    private ProductDTO product;

    public IntProductDataDTO(){}

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
