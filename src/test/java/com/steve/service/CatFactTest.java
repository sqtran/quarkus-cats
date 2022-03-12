package com.steve.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CatFactTest {

    @ParameterizedTest
    @CsvSource({"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"})
    void sillyGetterSetterTest(String input) {
        CatFact fact = new CatFact();
        fact.setFact(input);
        fact.setLength(input.length());

        assertEquals(input, fact.getFact());
        assertEquals(input.length(), fact.getLength());
    }

}
