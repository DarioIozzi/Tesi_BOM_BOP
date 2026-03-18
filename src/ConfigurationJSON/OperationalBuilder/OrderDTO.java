package ConfigurationJSON.OperationalBuilder;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private List<IntProductDataDTO> productsList;

    public OrderDTO(){}

    public void setProductsList(List<IntProductDataDTO> productslist){
        this.productsList = new ArrayList<>(productslist);
    }

    public List<IntProductDataDTO> getProductsList(){
        return productsList;
    }
}
