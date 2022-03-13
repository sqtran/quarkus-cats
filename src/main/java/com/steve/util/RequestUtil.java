package com.steve.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class RequestUtil {

    private static HttpClient httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .followRedirects(Redirect.ALWAYS)
        .connectTimeout(Duration.ofSeconds(10))
        .build();

     public static String getResource(String url)  {

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(url))
            .build();

            return httpClient.send(request, BodyHandlers.ofString()).body();

        } catch (IOException | InterruptedException ie) {
            return null;
        }
    }
}
