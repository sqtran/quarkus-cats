package com.steve.service;

import java.util.ArrayList;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.util.RequestUtil;

@ApplicationScoped
public class PersonService {

    @Inject
    RequestUtil util;

    public static final String PERSON_URL = "https://randomuser.me/api/";

    private final ObjectMapper mapper = new ObjectMapper();

    public Person retrieveRandomPerson() {

        System.out.println("Retrieving random person now");

        String json = util.getResource(PERSON_URL);

        return mapJsonToPerson(json);

    }


    private Person mapJsonToPerson(String json) {

        Person p = new Person();
        try {
            Map<String, Object> result = mapper.readValue(json, Map.class);

            p.setFirstName(getNameField(result, "first"));
            p.setLastName(getNameField(result, "last"));
            p.setTitle(getNameField(result, "title"));
            p.setCity(getAddressField(result, "city"));
            p.setState(getAddressField(result, "state"));
            p.setCountry(getAddressField(result, "country"));


         } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return p;
    }

    private String getNameField(Map<String, Object> map, String field) {
        return ((Map)((Map)((ArrayList)map.get("results")).get(0)).get("name")).get(field).toString();
    }

    private String getAddressField(Map<String, Object> map, String field) {
        return ((Map)((Map)((ArrayList)map.get("results")).get(0)).get("location")).get(field).toString();
    }

}
