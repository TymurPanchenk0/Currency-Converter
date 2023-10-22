package com.example.currencyConverter.model;

import java.util.ArrayList;

import static com.example.currencyConverter.utils.Utils.fetchDataFromURL;

public class ExchangeModel {
    private ArrayList<String> codes;

    public ArrayList<String> getCodes() {
        return codes;
    }

    public void setCodes(ArrayList<String> codes) {
        this.codes = codes;
    }

    public ExchangeModel() {
        var object = fetchDataFromURL("/codes"); // Fetch supported currency codes from the API
        var array = object.getJSONArray("supported_codes");
        var preparedArray = new ArrayList<String>();
        for (int i = 0; i < array.length(); i++) {
            preparedArray.add(array.getJSONArray(i).get(0).toString());
        }
        setCodes(preparedArray);
    }

    public double exchangeSubmit(double amount, String fromCode, String toCode) {
        var url = String.format("/pair/%s/%s/%s", fromCode, toCode, amount);
        var object = fetchDataFromURL(url); // Fetch and return the conversion result
        return object.getDouble("conversion_result");
    }
}
