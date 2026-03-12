package ConfigurationJSON.KnowledgeBuilder;
import Knowledge.*;
import Knowledge.Units.*;
import ConfigurationJSON.KnowledgeBuilder.Units.*;
import Others.IntProductTypeData;

import java.util.ArrayList;
import java.util.List;

public class TypeBuilder {

    public ProcessType buildProcessType(ProcessTypeDTO processtd){

        if (processtd == null)
            throw new IllegalArgumentException("ProcessTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();

        for(FeatureTypeDTO f: processtd.getFeatureTypes()){

            ftds.add(buildFeatureType(f));
        }

        List<ObservationType> obst = new ArrayList<>();

        for(ObservationTypeDTO o: processtd.getObservationTypes()){
            obst.add(buildObservationType(o));
        }

        return new ProcessType(processtd.getFamily(), ftds, obst);
    }

    public IntProductTypeData buildProductType(IntProductTypeDataDTO producttd){

        if (producttd == null)
            throw new IllegalArgumentException("ProductTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();

        for(FeatureTypeDTO f: producttd.getProductType().getFeatureTypes()){
            ftds.add(buildFeatureType(f));
        }

        if(producttd.getProductType() instanceof CompositeTypeDTO){
            List<IntProductTypeData> ptds = new ArrayList<>();
            for(IntProductTypeDataDTO p: ((CompositeTypeDTO) producttd.getProductType()).getChildren()){
                ptds.add(buildProductType(p));
            }
            return new IntProductTypeData(producttd.getQuantity(), new CompositeType(buildProcessType(producttd.getProductType().getProcessType()), producttd.getProductType().getFamily(), ftds, ptds));
        }

        return new IntProductTypeData(producttd.getQuantity(), new ElementType(producttd.getProductType().getFamily(), ftds, buildProcessType(producttd.getProductType().getProcessType()), buildResourceType(((ElementTypeDTO) producttd.getProductType()).getResourceType())));
    }

    public FeatureType buildFeatureType(FeatureTypeDTO ftd){

        if (ftd == null)
            throw new IllegalArgumentException("FeatureTypeDTO is null");

        List<UnitType> uts = new ArrayList<>();

        for(UnitTypeDTO u: ftd.getUnitTypes()) {
            uts.add(buildUnitType(u));
        }

        return new FeatureType(ftd.getName(), uts);
    }

    public ResourceType buildResourceType(ResourceTypeDTO rtd){

        if (rtd == null)
            throw new IllegalArgumentException("ResourceTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();

        for (FeatureTypeDTO f: rtd.getFeatureTypes()){

            ftds.add(buildFeatureType(f));
        }
        return new ResourceType(rtd.getFamily(), ftds);
    }

    public ObservationType buildObservationType(ObservationTypeDTO obst){

        if (obst == null)
            throw new IllegalArgumentException("ObservationTypeDTO is null");

        return new ObservationType(obst.getFamily());
    }

    public UnitType buildUnitType(UnitTypeDTO utd){

        if(utd == null)
            throw new IllegalArgumentException("UnitTypeDTO is null");

        if (utd instanceof LengthDTO)
            return new Length(utd.getValue());

        if (utd instanceof WeightDTO)
            return new Weight(utd.getValue());

        if (utd instanceof DensityDTO)
            return new Density(utd.getValue());

        if (utd instanceof TimeDTO)
            return new Time(utd.getValue());

        if (utd instanceof ThicknessDTO)
            return new Thickness(utd.getValue());

        if (utd instanceof WidthDTO)
            return new Width(utd.getValue());

        if (utd instanceof TextDTO)
            return new Text(utd.getValue());

        throw new IllegalArgumentException("Unknown UnitTypeDTO");
    }
}
