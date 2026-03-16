package Warehouse;

import java.util.HashMap;
import java.util.Map;

import Operational.Resource;

public class Warehouse {
    private final Map<Integer, Map<Integer, Resource>> resources = new HashMap<>();

    public void addResource(Resource resource) {

        if(resources.containsKey(resource.getType().getId())) {
            if (resources.get(resource.getType().getId()) == null) {
                Map<Integer, Resource> resourceList = new HashMap<>();
                resourceList.put(resource.getId(), resource);
                resources.put(resource.getType().getId(), new HashMap<>(resourceList));
            }
            else
                resources.computeIfPresent(resource.getType().getId(), (key, oldValue) -> {
                    oldValue.put(resource.getId(), resource);
                    return oldValue;
                });
        }
    }

    public void removeResource(int fam, int id) {

        resources.get(fam).remove(id);
    }
}
