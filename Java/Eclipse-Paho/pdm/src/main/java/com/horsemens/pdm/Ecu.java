package com.horsemens.pdm;

public class Ecu {
    public Sensor s;
    public String topic;
    public Ecu(BrokerConfig brokerConfig, String topic){
        this.s = new Sensor(brokerConfig);
        this.topic = topic;
    }

    public void publish(String message, int qos){
        s.publish(message, this.topic, qos);
    }
}
