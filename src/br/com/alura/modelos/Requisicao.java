package br.com.alura.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Requisicao {

    public Requisicao() throws IOException, InterruptedException {

        String chaveApi = "19f2157b3033ff9e4c633f33";
        String endereco = " https://v6.exchangerate-api.com/v6/" + chaveApi + "/pair/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
    }
}
