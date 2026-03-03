package ConfigurationJSON;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigurationTest {

    @Test
    public void readProductJSON_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ProductTypeDTO ptd = config.readProductJSON("/Product.json");
        assertEquals("vetro", ptd.getFamily());
        assertEquals(1, ptd.getFeatureTypes().size());
        assertEquals("perimetro", ptd.getFeatureTypes().get(0).getName());
        assertEquals(2, ptd.getFeatureTypes().get(0).getUnitsType().size());
        assertEquals("Length", ptd.getFeatureTypes().get(0).getUnitsType().get("Length").getName());
        assertEquals("Width", ptd.getFeatureTypes().get(0).getUnitsType().get("Width").getName());
    }

    @Test
    public void readProductJSON_missingFile() {
        Configuration config = new Configuration();
        assertThrows(IllegalArgumentException.class, () -> config.readProductJSON("/NonFile.json"));
    }

    @Test
    public void readProcessJSON_correctDTO() throws IOException {
        Configuration config = new Configuration();
        ProcessTypeDTO ptd = config.readProcessJSON("/Process.json");
        assertEquals("assemblare", ptd.getFamily());
        assertEquals(1, ptd.getFeatureTypes().size());
        assertEquals("descrizione", ptd.getFeatureTypes().get(0).getName());
        assertEquals(1, ptd.getFeatureTypes().get(0).getUnitsType().size());
        assertEquals("Text", ptd.getFeatureTypes().get(0).getUnitsType().get("Text").getName());
        assertTrue(ptd.getProductTypes().isEmpty());
    }

    @Test
    public void readProcessJSON_missingFile() {
        Configuration config = new Configuration();
        assertThrows(IllegalArgumentException.class, () -> config.readProcessJSON("/NonFile.json"));
    }
}
