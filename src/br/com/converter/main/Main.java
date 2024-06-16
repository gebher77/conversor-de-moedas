package br.com.converter.main;

import br.com.converter.methods.ApiClient;
import br.com.converter.models.Conversion;
import br.com.converter.models.ConversionResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ApiClient apiClient = new ApiClient();

            apiClient.apiConsume();

            ConversionResult conversionResult = gson.fromJson(apiClient.getJson(), ConversionResult.class);
            Conversion newConversion = new Conversion(conversionResult);
            System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>> %.2f [%s]",apiClient.getQtd(), newConversion.getBase(),newConversion.getConversion(),newConversion.getTarget());
        }catch (IllegalArgumentException e){
            System.out.println("Opção inválida, tente novamente!");
        }



    }
}
