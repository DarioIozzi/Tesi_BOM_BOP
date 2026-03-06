import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Operational.Resource;

public class Warehouse {
    private final Map<Integer, List<Resource>> resources = new HashMap<>();        //TODO c'è bisogno di tenere i product in memoria o resource --> risultato?

    public void addResource(Resource resource) {

        if(resources.containsKey(resource.getType().getId())) {
            if (resources.get(resource.getType().getId()) == null) {
                List<Resource> resourceList = new ArrayList<>();
                resourceList.add(resource);
                resources.put(resource.getType().getId(), new ArrayList<>(resourceList));
            }
            else
                resources.computeIfPresent(resource.getType().getId(), (key, oldValue) -> {

                    oldValue.add(resource);
                    return oldValue;
                });
        }
    }

    public void removeResource(int fam, int id) {

        if(resources.containsKey(fam) && resources.get(fam) != null) {
            resources.get(fam).remove(id);
        }
    }
}
