package ConfigurationJSON.OperationalBuilder;

import Knowledge.Catalogs.ResourceCatalog;
import Knowledge.CompositeType;
import Knowledge.Catalogs.ProductCatalog;
import Knowledge.ProductType;
import Knowledge.UnitType;
import Operational.Process;
import Operational.*;
import Operational.IntProductData;
import Knowledge.IntProductTypeData;
import Operational.OrderManager.Order;

import java.util.ArrayList;
import java.util.List;


public class OpBuilder {

    public Order buildOrder(OrderDTO odto){

        if (odto == null)
            throw new IllegalArgumentException("OrderDTO is null");

        List<IntProductData> pts= new ArrayList<>();

        for(IntProductDataDTO ipddto: odto.getProductsList()){
            pts.add(new IntProductData(ipddto.getQuantity(), buildProduct(ipddto.getProduct())));
        }

        return new Order(new ArrayList<>(pts));
    }

    public Product buildProduct(ProductDTO pdto){

        if (pdto == null)
            throw new IllegalArgumentException("ProductDTO is null");

        ProductCatalog pc = ProductCatalog.getInstance();
        ProductType productType = pc.getProductType(pdto.getTypeCode());

        if(productType instanceof CompositeType){
            List<IntProductData> products = new ArrayList<>();
            for(IntProductTypeData pt: productType.getChildren()){
                ProductDTO p = new ProductDTO();
                p.setTypeCode(pt.getProductType().getCode());
                products.add(new IntProductData(pt.getQuantity(), buildProduct(p)));
            }
            return new Composite(new Process(productType.getProcessType()), productType, products);
        }

        return new Element(productType, new Process(productType.getProcessType()));
    }

    public Resource buildResource(ResourceDTO resourcedto){

        if (resourcedto == null)
            throw new IllegalArgumentException("ResourceDTO is null");

        ResourceCatalog rc = ResourceCatalog.getInstance();

        return new Resource(resourcedto.getLotto(), rc.getResource(resourcedto.getCode()));
    }

    public Feature buildFeature(FeatureDTO feature, List<Unit> us){

        if (feature == null)
            throw new IllegalArgumentException("Feature is null");

        return new Feature(us);
    }

    public Observation buildObservation(ObservationDTO observationDTO){

        if (observationDTO == null)
            throw new IllegalArgumentException("ObservationDTO is null");

        return new Observation(observationDTO.getText());
    }

    public List<Unit> buildUnits(List<UnitDTO> unitdtos, List<UnitType> utds){
        List<Unit> units = new ArrayList<>();
        for(UnitDTO u: unitdtos){
            for(UnitType ut: utds) {
                if (u.getUnitType().equals(ut.getCode()))
                    units.add(new Unit(ut, u.getValue()));
            }
        }
        return units;
    }
}
