package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Instancia um novo client HTTP para solicitar a request
        HttpClient client = HttpClient.newHttpClient();

        // Instancia uma nova request HTTP, passando a url fornecida, informando para onde é a requisição.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=268954c4"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();


        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

        System.out.println("Título da OMDB: " +  meuTituloOmdb.toString());

        Titulo meuTitulo = new Titulo(meuTituloOmdb);

        System.out.println("Meu título convertido: " + meuTitulo);


    }
}
