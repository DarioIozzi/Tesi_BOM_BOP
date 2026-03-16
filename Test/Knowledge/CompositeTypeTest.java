package Knowledge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeTypeTest {

    @Before
    public void setUp(){
        ProductType.restCounter();
    }

    @Test
    public void addRemoveProductTypeTest() {

        CompositeType comp = new CompositeType();
        CompositeType comptest  = new CompositeType();
        IntProductTypeData ip = new IntProductTypeData(2, new ElementType());
        IntProductTypeData ip2 = new IntProductTypeData(1, new ElementType());
        comp.addProductType(ip);
        comptest.addProductType(ip2);
        assertNotNull(comp.getChild(ip.getProductType().getId()));
        assertEquals(2, comp.getChild(ip.getProductType().getId()).getQuantity());
        comp.addProductType(new IntProductTypeData(1, comptest));
        assertEquals(1, comp.getChild(comptest.getId()).getQuantity());
        comp.addProductType(new IntProductTypeData(1, comptest));
        assertEquals(2, comp.getChild(comptest.getId()).getQuantity());
        assertEquals(1, comp.getChild(ip2.getProductType().getId()).getQuantity());
        comp.removeProductType(comptest.getId(), 2);
        assertEquals(1, comp.getChildren().size());
    }
}
