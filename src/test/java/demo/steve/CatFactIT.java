package demo.steve;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import demo.steve.service.Person;
import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class CatFactIT {


    @Test
    public void testGetFact() {

        String response = given()
        .when()
            .get("/fact")
        .then()
            .assertThat()
                .statusCode(200)
         .extract().asString();

         assertNotNull(response);
         assertTrue(response.length() > 0);
    }

    @Test
    public void getGetCatFact() {

        String response = given()
        .when()
            .get("/catfact")
        .then()
            .assertThat().statusCode(200).extract().asString();

        assertNotNull(response);
        assertTrue(response.length() > 0);
    }

    @Test
    public void getPerson() {

        Person response = given()
        .when()
            .get("/person")
        .then()
            .assertThat().statusCode(200).extract().as(Person.class);

        assertNotNull(response);
        assertNotNull(response.getCity());
        assertNotNull(response.getState());
        assertNotNull(response.getCountry());
        assertNotNull(response.getFirstName());
        assertNotNull(response.getLastName());
        assertNotNull(response.getTitle());
    }
}
