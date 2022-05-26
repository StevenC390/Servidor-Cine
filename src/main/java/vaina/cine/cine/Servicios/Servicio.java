package vaina.cine.cine.Servicios;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.bson.json.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

/**
 *
 * @author pipet
 */
public class Servicio {
    String server = "";
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public Servicio(String server) {
        this.server = server;
    }

    public String GET(String endPoint) {
        String respuesta = "";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.server + endPoint))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            respuesta = response.body();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex);
        }
        return respuesta;
    }

    public String POST(String endPoint,JsonObject data) {
        String respuesta="";
        try {
            String postEndpoint = this.server + endPoint;
            String inputJson = data.toString();
            System.out.println("data "+inputJson);
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(postEndpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();

            var client = HttpClient.newHttpClient();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            respuesta=response.body();
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        return respuesta;
    }

    public String PUT(String endPoint,JsonObject data) {
        String respuesta="";
        try {
            String postEndpoint = this.server + endPoint;
            String inputJson = data.toString();
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(postEndpoint))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();

            var client = HttpClient.newHttpClient();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            respuesta=response.body();
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        return respuesta;
    }
    public String DELETE(String endPoint) {
        String respuesta="";
        try {
            String deleteEndpoint = this.server+endPoint;

            var request = HttpRequest.newBuilder()
                    .uri(URI.create(deleteEndpoint))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

            var client = HttpClient.newHttpClient();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        return respuesta;
    }
}
