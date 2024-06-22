package br.com.alura.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Requisicao {

    private String base_code;
    private String target_code;
    private double valor;

    List<Converte> listaConverte = new ArrayList<>();

    public Requisicao(Converte converte) {
        this.base_code = converte.getBase_code();
        this.target_code = converte.getTarget_code();
        this.valor = converte.getValor();

    }

    ;

    public List<Converte> getListaConversor() {
        return listaConverte;
    }

    public String requisicaoApi() throws IOException, InterruptedException {

        String ChaveAPI = "19f2157b3033ff9e4c633f33";
        String endereco = "https://v6.exchangerate-api.com/v6/"
                + ChaveAPI + "/pair/" + this.base_code + "/" + this.target_code + "/" + this.valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        Converte conversor = gson.fromJson(json, Converte.class);
        listaConverte.add(conversor);
        return conversor.toString();
    }
}
