package br.com.busca.endereco.menu;

import br.com.busca.endereco.Endereco;
import br.com.busca.endereco.gerar.GerarArquivo;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class MenuBuscar {
    Scanner scan = new Scanner(System.in);
    GerarArquivo gerarArquivo = new GerarArquivo();
    public Endereco buscarEndereco() {
        System.out.println("Digite o CEP que deseja buscar:");
        String cep = scan.nextLine();
        return buscaRequest(cep);
    }

    private Endereco buscaRequest(String cep) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/{cep}/json"
                        .replace("{cep}", cep)))
                .build();
        return gerarArquivo.buscarEndereco(request);
    }
}
