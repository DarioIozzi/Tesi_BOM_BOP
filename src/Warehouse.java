import java.util.HashMap;
import java.util.Map;

import Operational.Resource;

public class Warehouse {
    private Map<IntKeys, Resource> resources = new HashMap<>();

    public void addResource(Resource resource) {
        resources.put(new IntKeys(resource.getFamily, resource.getId), resource);
    }

    public boolean removeResource(int fam, int id) {
        return resources.remove(new IntKeys(fam, id)) != null;
    }
}
