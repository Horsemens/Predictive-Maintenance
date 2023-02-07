package com.horsemens.pdm;

public class Ecu {
    public Sensor s;
    public String topic;
    public Ecu(BrokerConfig brokerConfig, String topic){
        Sensor s = new Sensor(brokerConfig);
    }

    public void publish(String message, int qos){
        s.publish(message, this.topic, qos);
    }
}
