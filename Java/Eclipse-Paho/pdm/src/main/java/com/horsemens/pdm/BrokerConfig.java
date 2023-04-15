package com.horsemens.pdm;

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class BrokerConfig {

    private String broker       = "tcp://127.0.0.1:8083";
    private String clientId     = "default";
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
