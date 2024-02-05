package br.com.busca.endereco.gerar;

import br.com.busca.endereco.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GerarArquivo {
    HttpClient client = HttpClient.newHttpClient();
    static Endereco endereco;

    Gson gson = new Gson();
//    Gson gson = new GsonBuilder()
//            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//            .setPrettyPrinting()
//            .create();
    public Endereco buscarEndereco(HttpRequest request) {
        endereco = gson.fromJson(client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .join().body(), Endereco.class);
        return geradorArquivo(endereco);
    }

    private Endereco geradorArquivo(Endereco endereco) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escrita = null;
        try {
            escrita = new FileWriter("enderecos.json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(gson.toJson(endereco));
        return endereco;
    }


}
