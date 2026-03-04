package Knowledge;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementTypeTest {

    @Test
    public void notLegalMethods() {
        ElementType e = new ElementType("screw");
        ElementType et = new ElementType("stuff");
        assertThrows(UnsupportedOperationException.class, () -> e.addProductType(et));
        assertThrows(UnsupportedOperationException.class, () -> e.removeProductType(0));
    }
}
