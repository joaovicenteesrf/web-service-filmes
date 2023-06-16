package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Endereco;
import br.com.alura.screenmatch.modelos.EnderecoViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class PrincipalEndereco {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Qual CEP você gostaria de buscar??? ");

        String cep = teclado.nextLine();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String resposta = response.body();

        System.out.println(resposta);

        Gson gsonEndereco = new GsonBuilder()
                .create();


        // Instanciando um objeto Record com a resposta padronizada
        EnderecoViaCep enderecoViaCep = gsonEndereco.fromJson(resposta, EnderecoViaCep.class);

        System.out.println("Endereço da ViaCep: " + enderecoViaCep.toString());

        Endereco enderecoPadronizado = new Endereco(enderecoViaCep);

        System.out.println("Endereço final: " + enderecoPadronizado);




    }

}
