package com.steve.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.steve.service.CatFact;
import com.steve.service.CatService;
import com.steve.service.Person;
import com.steve.service.PersonService;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class CatController {

    @Inject
    CatService catSvc;

    @Inject
    PersonService personSvc;


    @GET
    @Path("/catfact")
    @Produces(value = "text/plain")
    public String getFact() {
        System.out.println("getting random cat fact quote now");

        CatFact fact = catSvc.retrieveRandomCatFact();
        Person p = personSvc.retrieveRandomPerson();

        return String.format("%s. %s %s from %s, %s, says \"%s\"", p.getTitle(), p.getFirstName(), p.getLastName(), p.getState(), p.getCountry(), fact.getFact());
    }


    @GET
    @Path("/fact")
    @Produces(value = "text/plain")
    public String getCatFact() throws IOException, InterruptedException {

        System.out.println("getting random cat fact now");

        return catSvc.retrieveRandomCatFact().getFact();

    }


    @GET
    @Path("/person")
    @Produces(value = "application/json")
    public Person getPerson() throws IOException, InterruptedException {

        System.out.println("getting random person now");

        return personSvc.retrieveRandomPerson();

    }


}