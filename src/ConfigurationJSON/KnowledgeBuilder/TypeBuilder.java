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

    public ProductType buildProductType(ProductTypeDTO p){

        if (p == null)
            throw new IllegalArgumentException("ProductTypeDTO is null");

        List<FeatureType> ftds = new ArrayList<>();
        for(FeatureTypeDTO f: p.getFeatureTypes()){
            ftds.add(buildFeatureType(f));
        }
        if(p instanceof CompositeTypeDTO){
            List<IntProductTypeData> iptds = new ArrayList<>();
            for(IntProductTypeDataDTO ip: ((CompositeTypeDTO) p).getChildren()){
                iptds.add(new IntProductTypeData(ip.getQuantity(), buildProductType(ip.getProductType())));
            }
            return new CompositeType(buildProcessType(p.getProcessType()), p.getFamily(), ftds, iptds);
        }else {
            return new ElementType(p.getFamily(), ftds, buildProcessType(p.getProcessType()), buildResourceType(((ElementTypeDTO) p).getResourceType()));
        }
    }

    public List<ProductType> buildProductListType(List<ProductTypeDTO> producttd){

        if (producttd == null)
            throw new IllegalArgumentException("ProductTypeDTO is null");

        List<ProductType> ptds = new ArrayList<>();

        for(ProductTypeDTO p: producttd){

            ptds.add(buildProductType(p));
        }

        return ptds;
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
