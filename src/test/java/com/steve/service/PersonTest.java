package com.steve.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class PersonTest {

    @Test
    void sillyGetterSetterTest() {
        Person p = Person.builder().firstName("Homer").lastName("Simpson").title("Mr.").city("Springfield").state("VA").country("USA").build();

        assertEquals("Homer", p.getFirstName());
        assertEquals("Simpson", p.getLastName());
        assertEquals("Mr.", p.getTitle());
        assertEquals("Springfield", p.getCity());
        assertEquals("VA", p.getState());
        assertEquals("USA", p.getCountry());

    }

}
