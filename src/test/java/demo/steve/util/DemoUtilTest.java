package demo.steve.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DemoUtilTest {

    DemoUtil util = new DemoUtil();

    @Test
    void testGetNumber() {
        assertNotNull(util.getNumber(5));
        assertEquals("1", util.getNumber(1));
        assertEquals("3", util.getNumber(3));
    }

    @Test
    void testGetFour() {
        assertNotNull(util.getFour());
        assertEquals("four", util.getFour());
    }

    @Test
    void testGetThree() {
        assertNotNull(util.getThree());
        assertEquals(3, util.getThree());
    }

    @Test
    void testGetTwo() {
        assertNotNull(util.getTwo());
        assertEquals(2, util.getTwo());
    }

    @Test
    void testGetOne() {
        assertNotNull(util.getOne());
        assertEquals(1, util.getOne());
    }
}