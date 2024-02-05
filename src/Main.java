import br.com.busca.endereco.Endereco;
import br.com.busca.endereco.menu.MenuBuscar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuBuscar menu = new MenuBuscar();
        menu.buscarEndereco();
        System.out.println("Busca realizada com sucesso!");
    }
}