package demo.steve.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;

import lombok.extern.java.Log;

@ApplicationScoped
@Log
public class RequestUtil {

    private HttpClient httpClient;

    public RequestUtil(HttpClient client) {
        httpClient = client;
    }

    public RequestUtil() {
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(Redirect.ALWAYS)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public String getResource(String url) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();

            log.info("Calling " + url);

            return httpClient.send(request, BodyHandlers.ofString()).body();

        } catch (IOException | InterruptedException ie) {
            log.info(ie.toString());
            return null;
        }
    }
}
