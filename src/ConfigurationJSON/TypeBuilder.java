package ConfigurationJSON;

import Knowledge.FeatureType;
import Knowledge.ProcessType;
import Knowledge.ProductType;

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
        return new ProcessType(, processtd.getFamily(), processtd.getProductTypes());
    }

    public ProductType buildProductType(){
        return new ProductType(, producttd.getFamily(), producttd.getFeatureTypes());            //TODO generazione automatica di id
    }

    public FeatureType buildFeatureType(){
        return new FeatureType(, ftd.getName(), ftd.getUnitsType());
    }
}
