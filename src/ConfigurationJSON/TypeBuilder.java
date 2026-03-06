package ConfigurationJSON;

import Knowledge.*;

import java.util.ArrayList;
import java.util.List;

public class TypeBuilder {

    private ProcessTypeDTO processtd;
    private ProductTypeDTO producttd;
    private FeatureTypeDTO ftd;
    private ResourceTypeDTO rtd;

    public TypeBuilder(ProcessTypeDTO processtd){
        if (processtd == null) {
            throw new IllegalStateException("ResourceTypeDTO is null");
        }
        this.processtd = processtd;
        this.producttd = null;
        this.ftd = null;
        this.rtd = null;
    }

    public TypeBuilder(ProductTypeDTO producttd){
        if (producttd == null) {
            throw new IllegalStateException("ResourceTypeDTO is null");
        }
        this.processtd = null;
        this.producttd = producttd;
        this.ftd = null;
        this.rtd = null;
    }

    public TypeBuilder(FeatureTypeDTO ftd){
        if (ftd == null) {
            throw new IllegalStateException("ResourceTypeDTO is null");
        }
        this.processtd = null;
        this.producttd = null;
        this.ftd = ftd;
        this.rtd = null;
    }

    public TypeBuilder(ResourceTypeDTO rtd){
        if (rtd == null) {
            throw new IllegalStateException("ResourceTypeDTO is null");
        }
        this.processtd = null;
        this.producttd = null;
        this.ftd = null;
        this.rtd = rtd;
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

    public ResourceType buildResourceType(){

        List<FeatureType> ftds = new ArrayList<>();

        for (FeatureTypeDTO f: rtd.getFeatureTypes()){
            ftds.add(new FeatureType(f.getName(), f.getUnitsType()));
        }
        return new ResourceType(rtd.getFamily(), ftds);
    }
}
