package ConfigurationJSON.KnowledgeBuilder;
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

        List<ObservationType> obst = new ArrayList<>();

        for(ObservationTypeDTO o: processtd.getObservationTypes()){
            obst.add(buildObservationType(o));
        }

        return new ProcessType(processtd.getFamily(), ftds, obst);
    }

    public ProductType buildProductType(ProductTypeDTO producttd){

        if (producttd == null)
            throw new IllegalArgumentException("ProductTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();

        for(FeatureTypeDTO f: producttd.getFeatureTypes()){
            ftds.add(buildFeatureType(f));
        }

        if(producttd instanceof CompositeTypeDTO){
            List<ProductType> ptds = new ArrayList<>();
            for(ProductTypeDTO p: ((CompositeTypeDTO) producttd).getChildren()){
                ptds.add(buildProductType(p));
            }
            return new CompositeType(buildProcessType(producttd.getProcessType()), producttd.getFamily(), ftds, ptds);
        }

        return new ElementType(producttd.getFamily(), ftds, buildProcessType(producttd.getProcessType()), buildResourceType(((ElementTypeDTO) producttd).getResourceType()));
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

    public ObservationType buildObservationType(ObservationTypeDTO obst){

        if (obst == null)
            throw new IllegalArgumentException("ObservationTypeDTO is null");

        return new ObservationType(obst.getFamily());
    }
}
