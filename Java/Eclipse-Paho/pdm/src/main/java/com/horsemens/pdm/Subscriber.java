package com.horsemens.pdm;

public class Subscriber {
    
    public Subscriber(BrokerConfig brokerConfig, String topic){
        ServerListener sl = new ServerListener(brokerConfig);
        sl.subscribe(topic);
    }
}
