package com.horsemens.pdm;

import java.io.InputStream;

public class App
{
    public static void main( String[] args )
    {
        //TODO: Optimize this code
        String clientId = System.getenv("CLIENTID");
        if(clientId == null){
            System.out.println("[ERROR] Client ID not set, Please set enviroment variable CLIENTID");
            System.exit(1);
        }

        String brokerUrl = System.getenv("BROKERURL");
        if(brokerUrl == null){
            System.out.println("[ERROR] Broker Url not set, Please set enviroment variable BROKERURL");
            System.exit(1);
        }

        BrokerConfig brokerConfig = new BrokerConfig(brokerUrl, clientId);

        String role = System.getenv("ROLE");
        if(role == null){
            System.out.println("[ERROR] Role not set, Please set enviroment variable ROLE");
            System.exit(1);
        }
        System.out.println(role);

        String topic = System.getenv("TOPIC");
        if(topic == null){
            System.out.println("[ERROR] Topic not set, Please set enviroment variable TOPIC");
            System.exit(1);
        }

        switch(role.toLowerCase()){
            case "thermalsensor":
                Ecu ecu1 = new Ecu(brokerConfig,topic);
                CsvSourcePublisher csvSourcePublisher1 = new CsvSourcePublisher(ecu1);
                csvSourcePublisher1.readAndPublish();
                break;
            case "subscriber":
                new Subscriber(brokerConfig, topic);
                break;
            case "ecu":
                Ecu ecu = new Ecu(brokerConfig,topic);
                CsvSourcePublisher csvSourcePublisher = new CsvSourcePublisher(ecu);
                csvSourcePublisher.readAndPublish();
                break;
            default:
                System.out.println("[ERROR] Invalid role");
                System.exit(1);
        }
    }




}



