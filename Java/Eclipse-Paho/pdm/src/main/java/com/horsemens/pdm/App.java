

package com.horsemens.pdm;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        BrokerConfig brokerConfig1 = new BrokerConfig("raj");
        Sensor s1 = new Sensor(brokerConfig1);
        s1.publish("this is raj", "pdm", 2);

//        BrokerConfig brokerConfig2 = new BrokerConfig("pratik");
//        ServerListener sl1 = new ServerListener(brokerConfig2);
//        sl1.subscribe("pdm");
    }



}



