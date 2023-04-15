package com.horsemens.pdm;
import java.net.http.HttpRequest;
import java.net.URI;

public class ApiRequest {
    
    public void sendData(String data){
        String url = System.getenv("API_URL");
        if(url == null){
            System.out.println("Using defautl url http://localhost:8000");
            url = "http://localhost:8000";
        }
        try{
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(url))
            .headers("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(data))
            .build();
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
}
