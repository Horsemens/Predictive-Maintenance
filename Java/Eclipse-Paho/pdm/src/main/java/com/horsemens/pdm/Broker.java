package com.horsemens.pdm;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Broker {
    private MqttClient client;

    public MqttClient getClient() {
        return client;
    }

    public Broker(BrokerConfig brokerConfig) {
        try {
            this.client = new MqttClient(brokerConfig.getBroker(), brokerConfig.getClientId(), brokerConfig.getPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+ brokerConfig.getBroker());
            this.client.connect(connOpts);
            System.out.println("Connected");

        }catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }

    }

}
