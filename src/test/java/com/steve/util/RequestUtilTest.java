package com.steve.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RequestUtilTest {

    @Test
    void testCallToService() throws Exception {
        String response = RequestUtil.getResource("https://example.com");
        assertNotNull(response);
        assertNotEquals("", response);
    }

    @Test
    void testExceptionCall() throws Exception {
        assertNull(RequestUtil.getResource("https://foo.bar.fizzbuzz"));
    }
}
