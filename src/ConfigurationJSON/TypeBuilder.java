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
    private List<FeatureTypeDTO> ftd = new ArrayList<>();

    TypeBuilder(ProcessTypeDTO processtd, ProductTypeDTO producttd, List<FeatureTypeDTO> ftd){
        this.processtd = processtd;
        this.producttd = producttd;
        this.ftd = new ArrayList<>(ftd);
    }

    public ProcessType buildProcessType(){
        return new ProcessType(processtd.getFamily(), processtd.getProductTypes());
    }

    public ProductType buildProductType(){
        return new ElementType(producttd.getFamily(), producttd.getFeatureTypes());
    }

    public List<FeatureType> buildFeatureType(){

        List<FeatureType> ftds = new ArrayList<>();
        for(FeatureTypeDTO f: ftd){
            ftds.add(new FeatureType(f.getName(), f.getUnitsType()));
        }
        return ftds;
    }
}
