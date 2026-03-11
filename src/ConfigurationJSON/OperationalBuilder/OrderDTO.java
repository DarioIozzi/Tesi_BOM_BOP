package ConfigurationJSON.OperationalBuilder;

import Others.IntProductData;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private List<IntProductData> productsList;

    public OrderDTO(){}

    public void setProductslist(List<IntProductData> productslist){
        this.productsList = new ArrayList<>(productslist);
    }

    public List<IntProductData> getProductsList(){
        return productsList;
    }
}
