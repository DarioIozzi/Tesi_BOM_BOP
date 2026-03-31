package Knowledge;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementTypeTest {

    @Before
    public void setUp(){
        ProductType.restCounter();
    }

    @Test
    public void notLegalMethods() {
        ElementType e = new ElementType();
        ElementType et = new ElementType();
        RequirementType p = new RequirementType(2, et);
        assertThrows(UnsupportedOperationException.class, () -> e.addProductType(p));
        assertThrows(UnsupportedOperationException.class, () -> e.removeProductType(0, 4));
        assertThrows(UnsupportedOperationException.class, () -> e.getChild(0));
        assertThrows(UnsupportedOperationException.class, e::getChildren);
        assertThrows(UnsupportedOperationException.class, e::getAllElement);
    }
}
