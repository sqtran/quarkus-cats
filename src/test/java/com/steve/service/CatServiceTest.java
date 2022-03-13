package com.steve.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.eq;

import java.io.IOException;

import com.steve.util.RequestUtil;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
public class CatServiceTest {

    @Mock
    private RequestUtil mockClient;

    @Test
    @Disabled
    void testRetrieveRandomCatFact() throws IOException, InterruptedException {


        given()
          .when().get("/catfact")
          .then()
             .statusCode(200)
             .body(is("test data 123"));
    }
}
