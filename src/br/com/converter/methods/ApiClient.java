package br.com.converter.methods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ApiClient {

    public String json;
    private double qtd;

    public double getQtd() {
        return qtd;
    }

    public String getJson() {
        return json;
    }

    public void apiConsume() throws IOException, InterruptedException {
        System.out.println("Digite a opção desejada");
        System.out.println("1) DÓLAR >>>> REAL");
        System.out.println("2) REAL >>>> DÓLAR");
        System.out.println("3) REAL >>>> PESO CHILENO");
        System.out.println("4) REAL >>>> PESO ARGENTINO");
        System.out.println("5) REAL >>>> PESO COLOMBIANO");

        Scanner scanner = new Scanner(System.in);
        int options = scanner.nextInt();
        String url = "";
        System.out.println("Digite a quantidade desejada");
        this.qtd = scanner.nextDouble();




        switch (options) {
            case 1:
                url = "https://v6.exchangerate-api.com/v6/1c545b3a1ee78a377642323e/pair/USD/BRL/" + qtd;
                break;
            case 2:
                url = "https://v6.exchangerate-api.com/v6/1c545b3a1ee78a377642323e/pair/BRL/USD/" + qtd;
                break;
            case 3:
                url = "https://v6.exchangerate-api.com/v6/1c545b3a1ee78a377642323e/pair/BRL/CLP/" + qtd;
                break;

            case 4:
                url = "https://v6.exchangerate-api.com/v6/1c545b3a1ee78a377642323e/pair/BRL/ARS/" + qtd;
                break;

            case 5:
                url = "https://v6.exchangerate-api.com/v6/1c545b3a1ee78a377642323e/pair/BRL/COP/" + qtd;
            default:
                break;
        }


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        this.json = response.body();

    }

}
