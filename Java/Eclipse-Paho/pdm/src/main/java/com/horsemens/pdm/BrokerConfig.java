package com.horsemens.pdm;

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class BrokerConfig {

    private int qos             = 2;
    private String broker       = "tcp://somesh-OMEN-Laptop-15-en0xxx:8083";
    private String clientId     = "clientId123";
    private MemoryPersistence persistence = new MemoryPersistence();


    public int getQos() {
        return qos;
    }

    public String getBroker() {
        return broker;
    }

    public String getClientId() {
        return clientId;
    }

    public MemoryPersistence getPersistence() {
        return persistence;
    }
}
