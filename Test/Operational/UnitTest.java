package Operational;

import Knowledge.UnitType;
import Knowledge.Units.Length;
import Knowledge.Units.Text;
import Knowledge.Units.Time;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void isValidTest(){
        UnitType ut = new Length(10d);
        UnitType ut2 = new Text("ciao");
        assertThrows(IllegalArgumentException.class, () -> new Unit(ut, "text"));
        assertThrows(IllegalArgumentException.class, () -> new Unit(ut, Duration.ofSeconds(1)));
        assertThrows(IllegalArgumentException.class, () -> new Unit(ut, Duration.ofSeconds(-1)));
        assertThrows(IllegalArgumentException.class, () -> new Unit(ut2, 4d));
        Unit u = new Unit(ut, 6d);
        assertNotNull(u);
        assertEquals(Length.class, u.getUnitType().getClass());
        assertEquals(6d, u.getValue());
        Unit u2 = new Unit(ut2, "text");
        assertNotNull(u2);
        assertEquals(ut2, u2.getUnitType());
        assertEquals("text", u2.getValue());
        UnitType ut3 = new Time(Duration.ofSeconds(4));
        Duration d = Duration.ofSeconds(5);
        Unit u3 = new Unit(ut3, d);
        assertNotNull(u3);
        assertEquals(ut3, u3.getUnitType());
        assertEquals(d, u3.getValue());
    }
}
