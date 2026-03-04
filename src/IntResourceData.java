import Operational.Resource;

import java.util.Objects;

public class IntResourceData {

    private int quantity;
    private Resource resource;

    public IntResourceData(int quantity, Resource resource) {
        if(quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");
        if(resource == null)
            throw new IllegalArgumentException("Resource cannot be null");
        this.quantity = quantity;
        this.resource = resource;
    }

    public int getQuantity() {
        return quantity;
    }

    public void modifyQuantity(int quantity) {
        this.quantity += quantity;
        if (this.quantity < 0)
            this.quantity = 0;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof IntResourceData)) return false;
        IntResourceData other = (IntResourceData) obj;
        return quantity == other.quantity && resource == other.getResource();
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, resource);
    }
}