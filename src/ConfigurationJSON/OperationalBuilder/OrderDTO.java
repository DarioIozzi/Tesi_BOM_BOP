package ConfigurationJSON.OperationalBuilder;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private List<RequirementDTO> productsList;

    public OrderDTO(){}

    public void setProductsList(List<RequirementDTO> productslist){
        this.productsList = new ArrayList<>(productslist);
    }

    public List<RequirementDTO> getProductsList(){
        return productsList;
    }
}
