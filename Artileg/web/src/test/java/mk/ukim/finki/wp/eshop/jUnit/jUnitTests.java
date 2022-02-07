package mk.ukim.finki.wp.eshop.jUnit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class jUnitTests {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
}
