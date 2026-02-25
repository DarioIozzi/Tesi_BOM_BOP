import java.util.Objects;

public class IntKeys {
    private final int key1;
    private final int key2;

    public IntKeys(int key1, int key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public int getKey1() {
        return key1;
    }

    public int getKey2() {
        return key2;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof IntKeys)) return false;
        IntKeys other = (IntKeys) obj;
        return key1 == other.key1 && key2 == other.key2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key1, key2);
    }
}
