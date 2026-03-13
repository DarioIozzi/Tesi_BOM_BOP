package Knowledge;

import Others.IntProductTypeData;
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
        comp.addProductType(new IntProductTypeData(2, new ElementType()));
        assertNotNull(comp.getChild(2));
        assertEquals(2, comp.getChild(2).getQuantity());
        comp.addProductType(new IntProductTypeData(1, comptest));
        assertEquals(1, comp.getChild(1).getQuantity());
        comp.addProductType(new IntProductTypeData(1, comptest));
        assertEquals(2, comp.getChild(1).getQuantity());
        comp.removeProductType(1, 2);
        assertEquals(1, comp.getChildren().size());
    }
}
