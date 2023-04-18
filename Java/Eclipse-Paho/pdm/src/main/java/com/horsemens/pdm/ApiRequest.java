package com.horsemens.pdm;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

public class ApiRequest {
    // public static void main(String args[]){
    //     String data = "{\"SensorId\":\"ecu1\",\"IgnitionTiming[Angle]\":\"248.0\",\"AFRDifference[AFR]\":\"13.0\",\"MAPSource[Pressure]\":\"399.0\",\"BaseFuel[Percentage]\":\"335.0\",\"CoolantTemp[Temperature]\":\"3242.0\",\"BatteryVoltage[BatteryVoltage]\":\"13075.0\",\"DateTime\":\"2023-04-16T11:52:05.210498293\",\"AirTemp[Temperature]\":\"3016.0\",\"RPM[EngineSpeed]\":\"1027.0\",\"LambdaSensor1[AFR]\":\"989.0\",\"BaseIgnition[AngleIgnSprt2K]\":\"320.0\"}";
    //     new ApiRequest().sendData(data);
    // }
    
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
