package demo.steve.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import demo.steve.service.CatFact;
import demo.steve.service.CatService;
import demo.steve.service.Person;
import demo.steve.service.PersonService;
import lombok.extern.java.Log;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Log
public class CatFactResource {

    @Inject
    CatService catSvc;

    @Inject
    PersonService personSvc;


    @GET
    @Path("/catfact")
    @Produces(value = "text/plain")
    public String getFact() {
        log.info("getting random cat fact quote now");

        CatFact fact = catSvc.retrieveRandomCatFact();
        Person p = personSvc.retrieveRandomPerson();

        return String.format("%s. %s %s from %s, %s, says \"%s\"", p.getTitle(), p.getFirstName(), p.getLastName(), p.getState(), p.getCountry(), fact.getFact());
    }


    @GET
    @Path("/fact")
    @Produces(value = "text/plain")
    public String getCatFact() throws IOException, InterruptedException {

        log.info("getting random cat fact now");
        return catSvc.retrieveRandomCatFact().getFact();

    }


    @GET
    @Path("/person")
    @Produces(value = "application/json")
    public Person getPerson() throws IOException, InterruptedException {

        log.info("getting random person now");

        return personSvc.retrieveRandomPerson();

    }


}