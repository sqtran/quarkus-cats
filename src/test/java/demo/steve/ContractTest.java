package demo.steve;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;

import org.junit.jupiter.api.Test;

import demo.steve.service.CatService;
import demo.steve.service.Person;
import demo.steve.service.PersonService;
import demo.steve.util.RequestUtil;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class ContractTest {

    private static final String FACT_RESPONSE = "{\"fact\": \"abc.\",\"length\":4}";

    private static final String PERSON_RESPONSE = "{\"results\":[{\"name\":{\"title\":\"Mr\",\"first\":\"Francisco\",\"last\":\"Almeida\"},\"location\":{\"city\":\"Ilhéus\",\"state\":\"Tocantins\",\"country\":\"Brazil\"}}]}";

    private static OpenApiValidationFilter openAPIFilter = new OpenApiValidationFilter("src/main/resources/openapi.yaml");

    @InjectMock
    RequestUtil mockUtil;

    @Test
    public void getGetCatFact() {

        when(mockUtil.getResource(eq(CatService.CAT_URL))).thenReturn(FACT_RESPONSE);
        when(mockUtil.getResource(eq(PersonService.PERSON_URL))).thenReturn(PERSON_RESPONSE);

        String response = given()
            .filter(openAPIFilter)
        .when()
            .get("/catfact")
        .then()
            .assertThat().statusCode(200).extract().asString();

        assertFalse("".equals(response));
    }

    @Test
    public void getPerson() {

        String expected = "{\"firstName\":\"Francisco\",\"lastName\":\"Almeida\",\"title\":\"Mr\",\"city\":\"Ilhéus\",\"state\":\"Tocantins\",\"country\":\"Brazil\"}";

        when(mockUtil.getResource(eq(PersonService.PERSON_URL))).thenReturn(PERSON_RESPONSE);


        Person response =
        given()
            .filter(openAPIFilter)
        .when()
            .get("/person")
        .then()
            .assertThat().statusCode(200).body(is(expected)).extract().as(Person.class);

        assertEquals("Francisco", response.getFirstName());
        assertEquals("Almeida", response.getLastName());
        assertEquals("Mr", response.getTitle());
        assertEquals("Ilhéus", response.getCity());
        assertEquals("Tocantins", response.getState());
        assertEquals("Brazil", response.getCountry());

    }

    @Test
    public void testGetFact() {

        when(mockUtil.getResource(eq(CatService.CAT_URL))).thenReturn(FACT_RESPONSE);

        String response = given()
            .filter(openAPIFilter)
        .when()
            .get("/fact")
        .then()
            .assertThat()
                .statusCode(200)
                .body(is("abc."))
        .extract().asString();

        assertEquals("abc.", response);

    }
}
