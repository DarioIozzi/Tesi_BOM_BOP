package Knowledge;

import Operational.Process;
import Others.IntProductData;
import Others.IntProductTypeData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ProductType {

    static int counter = 0;
    int id;
    ProcessType processType;
    String family;
    List<FeatureType> featureTypes;

    ProductType(ProcessType processType, String family, List<FeatureType> featureTypes) {

        this.featureTypes = new ArrayList<>(Objects.requireNonNull(featureTypes, "featureTypes cannot be null"));
        this.id = counter++;
        this.processType = processType;
        this.family = family;
    }

    public void addProductType(IntProductTypeData pt){
        throw new UnsupportedOperationException("Not a compositeType");
    }

    public boolean removeProductType(int id){
        throw new UnsupportedOperationException("Not a compositeType");
    }

    public IntProductTypeData getChild(int id) {
        return null;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public abstract int getId();

    public abstract boolean isThere(FeatureType ft);
}
