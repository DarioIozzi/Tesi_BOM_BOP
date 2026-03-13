package Operational;

import Knowledge.ElementType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class ElementTest {

    @Before
    public void setUp(){
        Product.resetCounter();
    }

    @Test
    public void thoseWhoThrowException(){

        ElementType et = new ElementType();
        Element e = new Element(et, new Process(null));
        assertNotNull(e);
        assertThrows(UnsupportedOperationException.class, () -> e.addProduct(null));
        assertThrows(UnsupportedOperationException.class, () -> e.removeProduct(5, 4));
        assertThrows(UnsupportedOperationException.class, e::getChildren);
        assertThrows(UnsupportedOperationException.class, () -> e.getChild(5));
    }
}
