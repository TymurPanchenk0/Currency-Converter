package com.example.currencyConverter.utils;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Utils {

    private static final String BAD_URL_MESSAGE = "Something wrong with URL";
    private static final String BAD_PROTOCOL_MESSAGE = "Something wrong with HTTP method";
    private static final String BAD_IO_MESSAGE = "Something wrong with parsing JSON";

    public static JSONObject fetchDataFromURL(String urlString) {
        try {
            var urlConfig = new URLConfig(); // Get the API URL from configuration
            var apiUrl = urlConfig.getApiUrl();
            var url = new URL(apiUrl + urlString); // Construct the full URL for the API request
            var connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            var in = connection.getInputStream();
            var text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            return new JSONObject(text); // Return JSON based on the request
        } catch (ProtocolException e) {
            throw new RuntimeException(BAD_PROTOCOL_MESSAGE, e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(BAD_URL_MESSAGE, e);
        } catch (IOException e) {
            throw new RuntimeException(BAD_IO_MESSAGE, e);
        }
    }
}
