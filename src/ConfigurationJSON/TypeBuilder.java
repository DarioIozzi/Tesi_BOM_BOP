package ConfigurationJSON;

import Knowledge.*;

import java.util.ArrayList;
import java.util.List;

public class TypeBuilder {

        public ProcessType buildProcessType(ProcessTypeDTO processtd){

        if (processtd == null)
            throw new IllegalArgumentException("ProcessTypeDTO is null");

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

    public ElementType buildProductType(ProductTypeDTO producttd){

        if (producttd == null)
            throw new IllegalArgumentException("ProductTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();

        for(FeatureTypeDTO f: producttd.getFeatureTypes()){
            ftds.add(new FeatureType(f.getName(), f.getUnitsType()));
        }
        return new ElementType(producttd.getFamily(), ftds);
    }

    public FeatureType buildFeatureType(FeatureTypeDTO ftd){

        if (ftd == null)
            throw new IllegalArgumentException("FeatureTypeDTO is null");

        return new FeatureType(ftd.getName(), ftd.getUnitsType());
    }

    public ResourceType buildResourceType(ResourceTypeDTO rtd){

        if (rtd == null)
            throw new IllegalArgumentException("ResourceTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();

        for (FeatureTypeDTO f: rtd.getFeatureTypes()){
            ftds.add(new FeatureType(f.getName(), f.getUnitsType()));
        }
        return new ResourceType(rtd.getFamily(), ftds);
    }
}
