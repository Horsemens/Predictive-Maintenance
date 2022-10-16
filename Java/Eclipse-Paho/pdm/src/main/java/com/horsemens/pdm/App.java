

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
        //TODO: add data simulation here
        for (int i=0; i<100; i++){
            s1.publish(Integer.toString(i), "pdm", 2);
        }
        s1.disconnect();

//        BrokerConfig brokerConfig2 = new BrokerConfig("pratik");
//        ServerListener sl1 = new ServerListener(brokerConfig2);
//        sl1.subscribe("pdm");
    }



}



