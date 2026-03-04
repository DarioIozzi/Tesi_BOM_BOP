import Operational.Product;

public class IntProductData {

    private int quantity;
    private Product product;

    public IntProductData(int quantity, Product product) {
        if(quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");
        if(product == null)
            throw new IllegalArgumentException("Product cannot be null");
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void modifyQuantity(int quantity) {
        this.quantity += quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
