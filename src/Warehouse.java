import java.util.HashMap;
import java.util.Map;

import Operational.Resource;

public class Warehouse {            //TODO Singleton?
    private final Map<Integer, IntResourceData> resources = new HashMap<>();

    public void addResource(IntResourceData resource) {

        if(resources.containsKey(resource.getResource().getType().getId())) {
            if (resources.get(resource.getResource().getType().getId()) == null)
                resources.put(resource.getResource().getType().getId(), resource);
            else
                resources.compute(resource.getResource().getType().getId(), (key, oldValue) -> {

                    oldValue.modifyQuantity(resource.getQuantity());
                    return oldValue;
                });
        }
    }

    public void removeResource(int fam, int q) {

        if(resources.containsKey(fam) && resources.get(fam) != null) {
            resources.get(fam).modifyQuantity(q);
        }
    }
}
