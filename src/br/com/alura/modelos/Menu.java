package br.com.alura.modelos;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    public void menu() throws IOException, InterruptedException {
        boolean menu = true;
        while (menu) {
            System.out.println("""
                  1 - BRL --> USD
                  2 - BRL --> EUR
                  3 - USD --> BRL
                  4 - EUR --> BRL
                  5 - USD --> EUR
                  6 - EUR --> USD
                  7 - SAIR
                  Escolha uma das Moedas a ser convertida
                  """);
            String opcao = sc.next();
            switch (opcao) {
                case "1":
                    this.converter("BRL", "USD");
                    break;

                case "2":
                    this.converter("BRL", "EUR");
                    break;

                case "3":
                    this.converter("USD", "BRL");
                    break;

                case "4":
                    this.converter("EUR", "BRL");
                    break;

                case "5":
                    this.converter("USD", "EUR");
                    break;

                case "6":
                    this.converter("EUR", "USD");
                    break;

                default:
                    if (opcao.equals("7")) {
                        System.out.println("Encerrando programa.");
                        menu = false;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
            }
        }

    }

    public void converter(String base_code, String target_code) throws IOException, InterruptedException {

        System.out.println("Digite o valor para fazer a conversão: ");
        double valor = this.sc.nextDouble();

        Converte converte = new Converte(base_code, target_code, valor);
        Requisicao api = new Requisicao(converte);
        System.out.println(api.requisicaoApi());
    }

}
