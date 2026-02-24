package Knowledge;

public class ProcessType {
    private int id;
    private String family;

    public ProcessType(int id, String family) {
        this.id = id;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
