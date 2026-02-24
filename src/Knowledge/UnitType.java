package Knowledge;

public interface UnitType {
    String getName();
    Class<?> getUnitClass();
    String getUnitOfMeasure();

    void setName(String name);
    void setUnitClass(Class<?> unitClass);
    void setUnitOfMeasure(String unitOfMeasure);
}
