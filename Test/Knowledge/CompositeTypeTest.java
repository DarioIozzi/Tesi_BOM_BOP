package Knowledge;

import Knowledge.Units.Length;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CompositeTypeTest {

    @Test
    public void thoseThatThrowExceptions() {
        CompositeType comp = new CompositeType();
        Length length = new Length();
        FeatureType ft = new FeatureType("name", Stream.of(new AbstractMap.SimpleEntry<>("Length", length)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        assertThrows(UnsupportedOperationException.class, comp::getId);
        assertThrows(UnsupportedOperationException.class, () -> comp.isThere(ft));
    }

    @Test
    public void addProductTypeTest() {
        CompositeType comp = new CompositeType();
        CompositeType comptest  = new CompositeType();
        List<FeatureType> ft = new ArrayList<>();
        Length length = new Length();
        ft.add(new FeatureType("name", Stream.of(new AbstractMap.SimpleEntry<>("Length", length)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
        comp.addProductType(new ElementType("Screws", ft));
        assertNotNull(comp.getChild(0));
        comp.addProductType(comptest);
    }
}
