package ConfigurationJSON;

import ConfigurationJSON.KnowledgeBuilder.*;
import Knowledge.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class TypeBuilderTest {

    @Test
    public void buildProductType_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ProductTypeDTO ptd = config.readProductJSON("/ProductType.json");
        ProductType pt = new TypeBuilder().buildProductType(ptd);
        assertNotNull(pt);
        assertEquals("Dining Chair", pt.getFamily());
        assertEquals(2, pt.getFeatureTypes().size());
        assertEquals("height", pt.getFeatureTypes().get(0).getName());
        assertEquals(1, pt.getFeatureTypes().get(0).getUnitTypes().size());
        assertEquals("Length", pt.getFeatureTypes().get(0).getUnitTypes().get(0).getName());
        assertEquals("Dining ChairAssembly", pt.getProcessType().getFamily());
        assertTrue(pt.getProcessType().getFeatureTypes().isEmpty());
        ProductType el = pt.getAllElement().get(0);
        assertEquals("WoodBeam", ((ElementType) el).getResourceType().getFamily());
    }

    @Test
    public void buildProductType_missingDTO() {

        ProductTypeDTO ptd = null;
        assertThrows(IllegalArgumentException.class, () -> new TypeBuilder().buildProductType(ptd));
    }

    @Test
    public void buildProcessType_missingDTO() {

        ProcessTypeDTO ptd = null;
        assertThrows(IllegalArgumentException.class, () -> new TypeBuilder().buildProcessType(ptd));
    }

    @Test
    public void buildFeatureType_missingDTO() {

        FeatureTypeDTO ftd = null;
        assertThrows(IllegalArgumentException.class, () -> new TypeBuilder().buildFeatureType(ftd));
    }

    @Test
    public void buildResourceType_missingDTO() {

        ResourceTypeDTO rtd = null;
        assertThrows(IllegalArgumentException.class, () -> new TypeBuilder().buildResourceType(rtd));
    }
}
