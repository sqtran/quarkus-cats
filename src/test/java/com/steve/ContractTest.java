package com.steve;

import static io.restassured.RestAssured.given;

import javax.inject.Inject;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import com.steve.service.CatService;
import com.steve.service.PersonService;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ContractTest {

    private static OpenApiValidationFilter openAPIFilter = new OpenApiValidationFilter("src/main/resources/openapi.yaml");

    @Inject
    CatService catSvc;

    @Inject
    PersonService personSvc;


    @Test
    public void testGetFact() {
        given()
            .filter(openAPIFilter)
        .when()
            .get("/fact")
        .then()
            .assertThat().statusCode(200);
    }

    @Test
    public void getGetCatFact() {
        given()
            .filter(openAPIFilter)
        .when()
            .get("/catfact")
        .then()
            .assertThat().statusCode(200);
    }

    @Test
    public void getPerson() {
        given()
            .filter(openAPIFilter)
        .when()
            .get("/person")
        .then()
            .assertThat().statusCode(200);
    }
}
