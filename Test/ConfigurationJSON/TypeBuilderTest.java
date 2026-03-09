package ConfigurationJSON;

import Knowledge.ElementType;
import Knowledge.FeatureType;
import Knowledge.ProcessType;
import Knowledge.ResourceType;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class TypeBuilderTest {

    @Test
    public void buildProductType_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ProductTypeDTO ptd = config.readProductJSON("/Product.json");
        ElementType pt = new TypeBuilder().buildProductType(ptd);
        assertNotNull(pt);
        assertEquals("vetro", pt.getFamily());
        assertEquals(1, pt.getFeatureTypes().size());
        assertEquals("perimetro", pt.getFeatureTypes().get(0).getName());
        assertEquals(2, pt.getFeatureTypes().get(0).getUnitsType().size());
        assertEquals("Length", pt.getFeatureTypes().get(0).getUnitsType().get("Length").getName());
        assertEquals("Width", pt.getFeatureTypes().get(0).getUnitsType().get("Width").getName());
    }

    @Test
    public void buildProcessType_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ProcessTypeDTO ptd = config.readProcessJSON("/Process.json");
        ProcessType pt = new TypeBuilder().buildProcessType(ptd);
        assertNotNull(pt);
        assertEquals("assemblare", pt.getFamily());
        assertTrue(pt.getProductTypes().isEmpty());
        assertNotNull(pt.getFeatureTypes());
        assertEquals("descrizione", pt.getFeatureTypes().get(0).getName());
        assertEquals("Text", pt.getFeatureTypes().get(0).getUnitsType().get("Text").getName());
    }

    @Test
    public void buildFeatureType_correctDTO() throws IOException {
        Configuration config = new Configuration();
        FeatureTypeDTO ftd = config.readFeatureJSON("/Feature.json");
        FeatureType ft = new TypeBuilder().buildFeatureType(ftd);
        assertNotNull(ft);
        assertEquals("specifiche fisiche", ft.getName());
        assertEquals(1, ft.getUnitsType().size());
        assertEquals("Weight", ft.getUnitsType().get("Weight").getName());
    }

    @Test
    public void buildResourceType_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ResourceTypeDTO rtd = config.readResourceJSON("/Resource.json");
        ResourceType rt = new TypeBuilder().buildResourceType(rtd);
        assertNotNull(rt);
        assertEquals("asse", rt.getFamily());
        assertEquals(1, rt.getFeatureTypes().size());
        assertEquals("perimetro", rt.getFeatureTypes().get(0).getName());
        assertEquals(2, rt.getFeatureTypes().get(0).getUnitsType().size());
        assertEquals("Length", rt.getFeatureTypes().get(0).getUnitsType().get("Length").getName());
        assertEquals("Width", rt.getFeatureTypes().get(0).getUnitsType().get("Width").getName());
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
