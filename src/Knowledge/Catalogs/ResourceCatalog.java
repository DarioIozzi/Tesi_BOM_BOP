package Knowledge.Catalogs;

import Knowledge.ResourceType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceCatalog {

    private static ResourceCatalog instance = null;
    Map<String, ResourceType> resourcesCatalog = new HashMap<>();

    private ResourceCatalog() {}

    public static ResourceCatalog getInstance() {
        if (instance == null)
            instance = new ResourceCatalog();

        return instance;
    }

    public ResourceType getResource(String fam) {
        return resourcesCatalog.get(fam);
    }

    public void addResource(ResourceType res) {
        resourcesCatalog.put(res.getFamily(), res);
    }

    public Map<String, ResourceType> getResourcesCatalog() {
        return resourcesCatalog;
    }
}
