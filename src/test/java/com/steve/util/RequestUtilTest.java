package com.steve.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RequestUtilTest {

    HttpClient mockHttpClient;
    HttpResponse mockResponse;
    RequestUtil util;

    @BeforeEach
    void setup() throws IOException, InterruptedException {
        mockHttpClient = Mockito.mock(HttpClient.class);
        mockResponse = Mockito.mock(HttpResponse.class);
        util = new RequestUtil(mockHttpClient);

        when(mockResponse.body()).thenReturn("something not null");

        HttpRequest goodRequest = HttpRequest.newBuilder().GET().uri(URI.create("https://a-good-url.here")).build();
        when(mockHttpClient.send(eq(goodRequest), any())).thenReturn(mockResponse);

        // throw an exception to test how the error is handled
        HttpRequest badRequest = HttpRequest.newBuilder().GET().uri(URI.create("https://foo.bar.fizzbuzz")).build();
        when(mockHttpClient.send(eq(badRequest), any())).thenThrow(new IOException("mock exception message"));
    }

    @Test
    void testCallToService() {
        String response = util.getResource("https://a-good-url.here");
        assertNotNull(response);
        assertNotEquals("", response);
    }

    @Test
    void testExceptionCall() throws Exception {
        assertNull(util.getResource("https://foo.bar.fizzbuzz"));
    }
}
