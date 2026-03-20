package Warehouse;

import java.util.HashMap;
import java.util.Map;

import Operational.Resource;

public class Warehouse {
    private final Map<String, Map<Integer, Resource>> resources = new HashMap<>();

    public void addResource(Resource resource) {

        if(resources.containsKey(resource.getType().getFamily())) {
            if (resources.get(resource.getType().getFamily()) == null) {
                Map<Integer, Resource> resourceList = new HashMap<>();
                resourceList.put(resource.getId(), resource);
                resources.put(resource.getType().getFamily(), new HashMap<>(resourceList));
            }
            else
                resources.computeIfPresent(resource.getType().getFamily(), (key, oldValue) -> {
                    oldValue.put(resource.getId(), resource);
                    return oldValue;
                });
        }else{
            Map<Integer, Resource> r = new HashMap<>();
            r.put(resource.getId(), resource);
            resources.put(resource.getType().getFamily(), r);
        }
    }

    public void removeResource(String fam, int id) {

        resources.get(fam).remove(id);
    }

    public Resource getResource(String fam, int id) {

        return resources.get(fam).get(id);
    }

    public Map<String, Map<Integer, Resource>> getResources() {
        return resources;
    }

    public void display(){
        for (Map.Entry<String, Map<Integer, Resource>> entry : resources.entrySet()) {
            for (Resource r : entry.getValue().values()) {
                System.out.println(r);
            }
        }
    }

    public void reset(){
        resources.clear();
    }
}
