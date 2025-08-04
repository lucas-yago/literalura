package br.com.alura.literalura.service;

import br.com.alura.literalura.exception.ApiRequestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    public String fetchData(String url) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
        }catch (IOException| InterruptedException e){
            throw new ApiRequestException("Erro ao fazer requisição para: " + url, e);
        }

        return response.body();
    }
}
