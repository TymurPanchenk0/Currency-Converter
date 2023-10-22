package com.example.currencyConverter.modelView;

import com.example.currencyConverter.model.ExchangeModel;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExchangeViewModel {
    private final ExchangeModel exchangeModel;
    // Properties for data binding
    private final StringProperty amount = new SimpleStringProperty("0");
    private final StringProperty fromCode = new SimpleStringProperty();
    private final StringProperty toCode = new SimpleStringProperty();
    private final DoubleProperty result = new SimpleDoubleProperty();
    private final StringProperty resultText = new SimpleStringProperty();

    private final ObservableList<String> supportedCodes = FXCollections.observableArrayList();

    public ExchangeViewModel(ExchangeModel exchangeModel) {
        this.exchangeModel = exchangeModel;
        supportedCodes.setAll(exchangeModel.getCodes());
    }

    public void exchange() {
        if (!isValidInput(amount.get())) {
            resultText.set("Wrong input. Please enter a valid amount");
            return;
        }
        if (fromCode.get() == null || toCode.get() == null) {
            resultText.set("Wrong input. Please choose a valid code");
            return;
        }
        // Perform the currency exchange
        double conversionResult = exchangeModel.exchangeSubmit(Double.parseDouble(amount.get()), fromCode.get(), toCode.get());
        result.set(conversionResult);
        resultText.set(String.valueOf(conversionResult));
    }

    private boolean isValidInput(String input) {
        try { // Check if the input is a valid number
            double amount = Double.parseDouble(input);
            return amount >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public StringProperty fromCodeProperty() {
        return fromCode;
    }

    public StringProperty toCodeProperty() {
        return toCode;
    }

    public DoubleProperty resultProperty() {
        return result;
    }

    public StringProperty resultTextProperty() {
        return resultText;
    }

    public ObservableList<String> getSupportedCodes() {
        return supportedCodes;
    }
}
