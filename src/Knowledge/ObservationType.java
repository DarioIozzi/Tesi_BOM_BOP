package Knowledge;

public class ObservationType {

    private String family;
    private String code;

    public ObservationType(String f){
        this.family = f;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String f) {
        this.family = f;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String c) {
        this.code = c;
    }
}