package Operational;

import java.util.Objects;

public class Requirement {

    private int quantity;
    private Product product;

    public Requirement(int quantity, Product product) {
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

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Requirement)) return false;
        Requirement other = (Requirement) obj;
        return quantity == other.getQuantity() && product == other.getProduct();
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product);
    }

    @Override
    public String toString() {
        return " [product = " + product.getType() + ", quantity = " + quantity + "]\n";
    }
}
