

package com.horsemens.pdm;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        ServerListener listener = new ServerListener();
//        listener.subscribe("pdm");


        SensorOne sensor1 = new SensorOne();
        sensor1.publish("this is sensor 1", "pdm");



    }



}



