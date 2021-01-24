package com.karaf.bundle;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Caller {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/greeting");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            System.out.println("\ncalling the API...");
            System.out.println("response code: " + connection.getResponseCode());
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //Read JSON response and print
            JSONObject myResponse = new JSONObject(response.toString());
            System.out.println("\nretrieving information from the JSON response....");
            System.out.println("id - " +myResponse.getString("id"));
            System.out.println("content - " +myResponse.getString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
