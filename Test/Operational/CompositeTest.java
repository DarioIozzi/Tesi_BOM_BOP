package Operational;

import Knowledge.CompositeType;
import Others.IntProductData;
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
        comp.addProduct(new IntProductData(2, new Element()));
        comptest.addProduct(new IntProductData(1, new Element()));
        assertNotNull(comp.getChild(2));
        assertEquals(2, comp.getChild(2).getQuantity());
        comp.addProduct(new IntProductData(1, comptest));                   //TODO correggi con getId e non hardcoded
        assertEquals(1, comp.getChild(1).getQuantity());
        comp.addProduct(new IntProductData(1, comptest));
        assertEquals(2, comp.getChild(1).getQuantity());
        assertEquals(1, comp.getChild(3).getQuantity());
        comp.removeProduct(1, 2);
        assertEquals(1, comp.getChildren().size());
    }
}
