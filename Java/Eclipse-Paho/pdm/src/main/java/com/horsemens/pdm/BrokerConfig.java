package com.horsemens.pdm;

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class BrokerConfig {

    private String broker       = "tcp://somesh-OMEN-Laptop-15-en0xxx:8083";
    private String clientId     = "clientId124";
    private MemoryPersistence persistence = new MemoryPersistence();

    public BrokerConfig(String broker, String clientId) {
        this.broker = broker;
        this.clientId = clientId;
    }

    public BrokerConfig(String clientId) {
        this.clientId = clientId;
    }


    public BrokerConfig(){
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
