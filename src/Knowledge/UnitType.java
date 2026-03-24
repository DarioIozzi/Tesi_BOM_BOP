package Knowledge;

public abstract class UnitType {

    private static int counter = 0;
    protected int id;
    protected String name;
    protected Class<?> unitClass;
    protected String unitOfMeasure;
    protected Object unitValue;
    protected String code;

    public UnitType(Object value){

        this.id = counter++;
        this.unitValue = value;
    }

    public String getName(){
        return name;
    }
    public Class<?> getUnitClass(){
        return unitClass;
    }

    public String getUnitOfMeasure(){
        return unitOfMeasure;
    }

    public Object getUnitValue(){
        return unitValue;
    }

    public int getId(){
        return id;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
}
