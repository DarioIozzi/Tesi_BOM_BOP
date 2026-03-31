package Operational;

import Knowledge.CompositeType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CompositeTest {

    @Before
    public void setUp(){
        Product.resetCounter();
    }

    @Test
    public void thoseWhoThrowException() {

        assertThrows(NullPointerException.class ,() -> new Composite(new Process(null), new CompositeType(), null));
    }

    @Test
    public void addRemoveProductTypeTest() {

        Composite comp = new Composite();
        Composite comptest  = new Composite();
        Requirement ip = new Requirement(2, new Element());
        Requirement ip2 = new Requirement(1, new Element());
        comp.addProduct(ip);
        comptest.addProduct(ip2);
        assertNotNull(comp.getChild(ip.getProduct().getId()));
        assertEquals(2, comp.getChild(ip.getProduct().getId()).getQuantity());
        comp.addProduct(new Requirement(1, comptest));
        assertEquals(1, comp.getChild(comptest.getId()).getQuantity());
        comp.addProduct(new Requirement(1, comptest));
        assertEquals(2, comp.getChild(comptest.getId()).getQuantity());
        assertEquals(1, comp.getChild(ip2.getProduct().getId()).getQuantity());
        comp.removeProduct(comptest.getId(), 2);
        assertEquals(1, comp.getChildren().size());
    }
}
