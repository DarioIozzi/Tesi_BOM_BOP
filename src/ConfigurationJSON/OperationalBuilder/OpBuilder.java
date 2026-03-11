package ConfigurationJSON.OperationalBuilder;

import Knowledge.CompositeType;
import Operational.Composite;
import Operational.Element;
import Operational.Feature;
import Operational.Product;
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
        for (IntProductData p: odto.getProductsList()) {

            for (Feature f : p.getProduct().getFeatures()) {
                fts.add(new Feature(f.getType(), f.getUnits()));
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
            fts.add(new Feature(f.getType(), f.getUnits()));
        }

        if(pdto.getType() instanceof CompositeType){
            for()
        }

        return new Element(pdto.getType(), , fts);
    }
}
