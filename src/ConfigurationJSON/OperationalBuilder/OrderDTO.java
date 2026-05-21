package ConfigurationJSON.OperationalBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private List<RequirementDTO> productsList;
    private LocalDate deadline;

    public OrderDTO(){}

    public void setProductsList(List<RequirementDTO> productslist){
        this.productsList = new ArrayList<>(productslist);
    }

    public List<RequirementDTO> getProductsList(){
        return productsList;
    }

    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

    public LocalDate getDeadline(){
        return deadline;
    }
}
