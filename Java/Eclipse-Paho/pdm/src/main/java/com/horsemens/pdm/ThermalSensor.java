package com.horsemens.pdm;

public class ThermalSensor {
    public ThermalSensor(BrokerConfig brokerConfig, String topic){
        Sensor s = new Sensor(brokerConfig);

        for (int i=100; i<200; i++){
            s.publish(Integer.toString(i), topic, 2);
        }

        s.disconnect();
    }


}
