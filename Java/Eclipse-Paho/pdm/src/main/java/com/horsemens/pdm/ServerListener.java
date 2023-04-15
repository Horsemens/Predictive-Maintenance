package com.horsemens.pdm;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import com.horsemens.pdm.ApiRequest;


public class ServerListener implements MqttCallback {
    private Broker broker;
    public ServerListener(BrokerConfig brokerConfig) {
        this.broker = new Broker(brokerConfig);
    }

    public void subscribe(String topic){
        try {

            this.broker.getClient().setCallback(this);
            this.broker.getClient().subscribe(topic);

        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) throws RuntimeException  {
        System.out.println("Connection Lost");
        System.out.println(throwable.getMessage());
        throw new RuntimeException("Connection Lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage);
        ApiRequest requestObj = new ApiRequest();
        requestObj.sendData(mqttMessage.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
