package Operational;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompositeTest {

    @Test
    public void thoseWhoThrowException() {

        Composite c = new Composite();
        assertNotNull(c);
        assertThrows(UnsupportedOperationException.class, c::getId);
    }
}
