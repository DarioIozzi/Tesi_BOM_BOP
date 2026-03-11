package ConfigurationJSON.OperationalBuilder;

import Knowledge.CompositeType;
import Knowledge.ProductType;
import Operational.*;
import Operational.Process;
import Others.IntProductData;
import Others.Order;

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

        if(pdto.getType() instanceof CompositeType){
            List<Product> products = new ArrayList<>();
            for(ProductType pt: ((CompositeType) pdto.getType()).getChildren()){
                ProductDTO p = new ProductDTO();
                p.setType(pt);
                products.add(buildProduct(p));
            }
            return new Composite(new Process(pdto.getType().getProcessType()), pdto.getType(), products);
        }

        return new Element(pdto.getType(), new Process(pdto.getType().getProcessType()));
    }

    public Resource buildResource(ResourceDTO resourcedto){

        if (resourcedto == null)
            throw new IllegalArgumentException("ResourceDTO is null");

        return new Resource(resourcedto.getLotto(), resourcedto.getResourceType());
    }

    public Feature buildFeature(FeatureDTO feature){

        if (feature == null)
            throw new IllegalArgumentException("Feature is null");

        return new Feature(feature.getType(), feature.getUnits());
    }
}
