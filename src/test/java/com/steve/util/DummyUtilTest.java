package com.steve.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DummyUtilTest {

    DummyUtil util = new DummyUtil();


    @Test
    void testGetNumber() {
        assertNotNull(util.getNumber(5));
    }

    @Test
    void testGetFour() {
        assertNotNull(util.getFour());
    }

    @Test
    void testGetThree() {
        assertNotNull(util.getThree());
    }

    @Test
    void testGetTwo() {
        assertNotNull(util.getTwo());

    }

    @Test
    void testGetOne() {
        assertNotNull(util.getOne());
    }
}
