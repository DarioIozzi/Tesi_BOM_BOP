package Knowledge;

public abstract class UnitType {
    protected String name;
    protected Class<?> unitClass;
    protected String unitOfMeasure;

    public String getName(){
        return name;
    }
    public Class<?> getUnitClass(){
        return unitClass;
    }

    public String getUnitOfMeasure(){
        return unitOfMeasure;
    }
}
