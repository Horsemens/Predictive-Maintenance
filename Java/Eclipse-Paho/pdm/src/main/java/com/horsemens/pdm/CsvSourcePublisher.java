package com.horsemens.pdm;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.CacheRequest;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CsvSourcePublisher {
    private Ecu ecu;

    public CsvSourcePublisher(Ecu ecu) {
        this.ecu = ecu;
    }
    public CsvSourcePublisher() {
        this.ecu = null;
    }

//    public static  void main(String[] args){
//        new CsvSourcePublisher().readAndPublish();
//    }

    public void readAndPublish(){
        String line = "";
        String splitBy = ",";
        InputStream csvFile = getCsvFile();
        try (InputStreamReader streamReader =
                     new InputStreamReader(csvFile, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            while ((line = reader.readLine()) != null) {
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
                Thread.sleep(10000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public InputStream getCsvFile(){
        try {

            InputStream resource = getClass().getClassLoader().getResourceAsStream("all-data.csv");

            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                return resource;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
