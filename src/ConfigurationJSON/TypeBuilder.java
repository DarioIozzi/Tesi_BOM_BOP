package ConfigurationJSON;

import Knowledge.ElementType;
import Knowledge.FeatureType;
import Knowledge.ProcessType;
import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public class TypeBuilder {

    private final ProcessTypeDTO processtd;
    private final ProductTypeDTO producttd;
    private final FeatureTypeDTO ftd;

    TypeBuilder(ProcessTypeDTO processtd, ProductTypeDTO producttd, FeatureTypeDTO ftd){
        this.processtd = processtd;
        this.producttd = producttd;
        this.ftd = ftd;
    }

    public ProcessType buildProcessType(){

        List<FeatureType> ftds = new ArrayList<>();
        for(FeatureTypeDTO f: processtd.getFeatureTypes()){
            ftds.add(new FeatureType(f.getName(), f.getUnitsType()));
        }

        List<ProductType> pt = new ArrayList<>();
        List<FeatureType> ftdss = new ArrayList<>();
        for(ProductTypeDTO p: processtd.getProductTypes()){
            ftdss.clear();
            for(FeatureTypeDTO f: p.getFeatureTypes()) {
                ftdss.add(new FeatureType(f.getName(), f.getUnitsType()));
            }
            pt.add(new ElementType(p.getFamily(), ftdss));
        }

        return new ProcessType(processtd.getFamily(), ftds, pt);
    }

    public ElementType buildProductType(){

        List<FeatureType> ftds = new ArrayList<>();
        for(FeatureTypeDTO f: producttd.getFeatureTypes()){
            ftds.add(new FeatureType(f.getName(), f.getUnitsType()));
        }
        return new ElementType(producttd.getFamily(), ftds);
    }

    public FeatureType buildFeatureType(){

        return new FeatureType(ftd.getName(), ftd.getUnitsType());
    }
}
