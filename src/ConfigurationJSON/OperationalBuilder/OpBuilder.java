package ConfigurationJSON.OperationalBuilder;

import Knowledge.CompositeType;
import Knowledge.ElementType;
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
        List<Feature> fts = new ArrayList<>();
        for (IntProductData p: odto.getProductsList()) {        //TODO IntProductDataDTO??

            for (Feature f : p.getProduct().getFeatures()) {
                fts.add(buildFeature(f));
            }

            pts.add(new IntProductData(p.getQuantity(), new Composite(p.getProduct().getProcess(), p.getProduct().getType(), fts, )));
        }

        return new Order(new ArrayList<>(pts));
    }

    public Product buildProduct(ProductDTO pdto){

        if (pdto == null)
            throw new IllegalArgumentException("ProductDTO is null");

        List<Feature> fts = new ArrayList<>();
        for(FeatureDTO f: pdto.getFeatures()){
            fts.add(buildFeature(f));
        }

        if(pdto.getType() instanceof CompositeType){
            for()
        }

        return new Element(pdto.getType(), buildProcess(pdto.getProcess()), fts, );
    }

    public Process buildProcess(ProcessDTO processdto){

        if (processdto == null)
            throw new IllegalArgumentException("ProcessDTO is null");

        List<Feature> fts = new ArrayList<>();
        for(FeatureDTO f: processdto.getFeatures()){
            fts.add(buildFeature(f));
        }

        return new Process(processdto.getProcessType(), fts);
    }

    public Resource buildResource(ResourceDTO resourcedto){

        if (resourcedto == null)
            throw new IllegalArgumentException("ResourceDTO is null");

        List<Feature> fts = new ArrayList<>();
        for(FeatureDTO f: resourcedto.getFeatures()){
            fts.add(buildFeature(f));
        }

        return new Resource(resourcedto.getLotto(), resourcedto.getResourceType(), fts);
    }

    public Feature buildFeature(FeatureDTO feature){

        if (feature == null)
            throw new IllegalArgumentException("Feature is null");

        return new Feature(feature.getType(), feature.getUnits());
    }
}
