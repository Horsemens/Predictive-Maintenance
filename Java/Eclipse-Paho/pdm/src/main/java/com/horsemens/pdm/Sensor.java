package com.horsemens.pdm;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Scanner;

public class Sensor {
    private Broker broker;
    public Sensor(BrokerConfig brokerConfig){
        this.broker = new Broker(brokerConfig);
    }

    public void publish(String payload, String topic, int qos){
        try {
            MqttMessage message = new MqttMessage(payload.getBytes());
            message.setQos(qos);
            broker.getClient().publish(topic, message);
            System.out.println("Message published");
            broker.getClient().disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}
