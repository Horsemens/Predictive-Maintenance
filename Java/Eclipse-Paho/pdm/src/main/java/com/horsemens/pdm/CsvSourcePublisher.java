package com.horsemens.pdm;

import java.io.*;
import java.net.URL;

public class CsvSource {
    public static void main( String[] args ){
        CsvSource csvSource = new CsvSource();
        File csvFile = csvSource.getCsvFile();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator
                System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
            }
        }
        catch (IOException e)
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
