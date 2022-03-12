package com.steve.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CatFactTest {

    @Test
    void sillyGetterSetterTest() {
        CatFact fact = new CatFact();
        fact.setFact("Test fact here");
        fact.setLength("Test fact here".length());

        assertEquals("Test fact here", fact.getFact());
        assertEquals("Test fact here".length(), fact.getLength());
    }

}
