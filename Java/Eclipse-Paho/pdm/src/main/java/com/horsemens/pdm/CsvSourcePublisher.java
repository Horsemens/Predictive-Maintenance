package com.horsemens.pdm;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.URL;

public class CsvSourcePublisher {
    private Ecu ecu;

    public CsvSourcePublisher(Ecu ecu) {
        this.ecu = ecu;
    }

    public void readAndPublish(){
        File csvFile = getCsvFile();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] data = line.split(splitBy);    // use comma as separator

                //creating json to be published
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("AFRDifference[AFR]", data[2]);
                jsonObject.put("BatteryVoltage[BatteryVoltage]", data[3]);
                jsonObject.put("IgnitionTiming[Angle]", data[5]);
                jsonObject.put("AirTemp[Temperature]", data[6]);
                jsonObject.put("CoolantTemp[Temperature]", data[7]);
                jsonObject.put("MAPSource[Pressure]", data[8]);
                jsonObject.put("RPM[EngineSpeed]", data[14]);

                //publishing
                ecu.publish(jsonObject.toJSONString(), 2);
                Thread.sleep(1000);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public File getCsvFile(){
        try {

            URL resource = getClass().getClassLoader().getResource("all-data.csv");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                return new File(resource.toURI());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
