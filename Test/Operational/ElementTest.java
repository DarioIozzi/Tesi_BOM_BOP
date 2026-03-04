package Operational;

import Knowledge.ElementType;
import Knowledge.FeatureType;
import Knowledge.ResourceType;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElementTest {

    @Test
    public void thoseWhoThrowException(){
        ResourceType rt = new ResourceType("steel");
        ElementType et = new ElementType("screw");
        Resource r = new Resource(1, rt);
        Element e = new Element(et, r);
        assertNotNull(e);
        assertThrows(UnsupportedOperationException.class, () -> e.addProduct(null));
        assertThrows(UnsupportedOperationException.class, () -> e.removeProduct(5));
        //typeCheckTest
        FeatureType ft = new FeatureType("Test");
        FeatureType ft2 = new FeatureType("Test2");
        Feature f = new Feature(ft);
        Feature f2 = new Feature(ft2);
        et.addFeatureType(ft);
        e.addFeature(f);
        e.addFeature(f2);
        e.getFeatures();
        assertEquals(1, e.getFeatures().size());
    }
}
