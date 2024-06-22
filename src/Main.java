import br.com.alura.modelos.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("****** Bem-vindo ao nosso conversor de Moedas! ******");

        Menu menu = new Menu();
        menu.menu();
    }
}