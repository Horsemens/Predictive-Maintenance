package com.horsemens.pdm;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

public class ApiRequest {

    public void sendData(String data){
        System.out.println(data);
        String url = System.getenv("API_URL");
        if(url == null){
            System.out.println("Using defautl url http://localhost:8000/api/test");
            url = "http://localhost:8000/api/insert/";
        }
        try{

            HttpRequest request = HttpRequest.newBuilder()
                                            .uri(new URI(url))
                                            .POST(HttpRequest.BodyPublishers.ofString(data))
                                            .build();

            HttpResponse<String> response = HttpClient
                                            .newBuilder()
                                            .build()
                                            .send(request, BodyHandlers.ofString());

            System.out.println(response);
            
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
}
