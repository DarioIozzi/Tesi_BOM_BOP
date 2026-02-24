package Knowledge.Units;

import Knowledge.UnitType;

public class Density implements UnitType {
    private String name;
    private Class<?> UnitClass;
    private String unitOfMeasure;

    public Density(Class<?> UnitClass, String name, String unitOfMeasure) {
        this.UnitClass = UnitClass;
        this.name = name;
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Class<?> getUnitClass(){
        return UnitClass;
    }

    @Override
    public String getUnitOfMeasure(){
        return unitOfMeasure;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setUnitClass(Class<?> UnitClass){
        this.UnitClass = UnitClass;
    }

    @Override
    public void setUnitOfMeasure(String unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
    }
}
