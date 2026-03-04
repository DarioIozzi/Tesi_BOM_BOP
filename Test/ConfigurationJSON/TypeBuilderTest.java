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
        ElementType pt = new TypeBuilder(ptd).buildProductType();
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
        ProcessType pt = new TypeBuilder(ptd).buildProcessType();
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
        FeatureType ft = new TypeBuilder(ftd).buildFeatureType();
        assertNotNull(ft);
        assertEquals("specifiche fisiche", ft.getName());
        assertEquals(1, ft.getUnitsType().size());
        assertEquals("Weight", ft.getUnitsType().get("Weight").getName());
    }

    @Test
    public void buildResourceType_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ResourceTypeDTO rtd = config.readResourceJSON("/Resource.json");
        ResourceType rt = new TypeBuilder(rtd).buildResourceType();
        assertNotNull(rt);
        assertEquals("asse", rt.getFamily());
        assertEquals(1, rt.getFeatureTypes().size());
        assertEquals("perimetro", rt.getFeatureTypes().get(0).getName());
        assertEquals(2, rt.getFeatureTypes().get(0).getUnitsType().size());
        assertEquals("Length", rt.getFeatureTypes().get(0).getUnitsType().get("Length").getName());
        assertEquals("Width", rt.getFeatureTypes().get(0).getUnitsType().get("Width").getName());
    }

    @Test
    public void buildProductType_missingDTO() throws IOException {

        ProductTypeDTO ptd = null;
        assertThrows(IllegalStateException.class, () -> new TypeBuilder(ptd).buildProductType());
    }

    @Test
    public void buildProcessType_missingDTO() throws IOException {

        ProcessTypeDTO ptd = null;
        assertThrows(IllegalStateException.class, () -> new TypeBuilder(ptd).buildProcessType());
    }

    @Test
    public void buildFeatureType_missingDTO() throws IOException {

        FeatureTypeDTO ftd = null;
        assertThrows(IllegalStateException.class, () -> new TypeBuilder(ftd).buildFeatureType());
    }

    @Test
    public void buildResourceType_missingDTO() throws IOException {

        ResourceTypeDTO rtd = null;
        assertThrows(IllegalStateException.class, () -> new TypeBuilder(rtd).buildResourceType());
    }
}
