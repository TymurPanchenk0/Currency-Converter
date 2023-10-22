package com.example.currencyConverter.view;

import com.example.currencyConverter.model.ExchangeModel;
import com.example.currencyConverter.modelView.ExchangeViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ExchangeView implements Initializable {
    private final ExchangeModel exchangeModel;
    private final ExchangeViewModel viewModel;

    @FXML
    Label amountName;
    @FXML
    TextField amount;
    @FXML
    Label fromName;
    @FXML
    ComboBox<String> from;
    @FXML
    Label toName;
    @FXML
    ComboBox<String> to;
    @FXML
    Button submit;
    @FXML
    Label result;
    @FXML
    Label resultText;

    @FXML
    void exchangeClick() {
        viewModel.exchange();
    }

    public ExchangeView() {
        this.exchangeModel = new ExchangeModel();
        this.viewModel = new ExchangeViewModel(exchangeModel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Bind UI elements to the view model properties
        amount.textProperty().bindBidirectional(viewModel.amountProperty());
        from.setItems(viewModel.getSupportedCodes());
        from.valueProperty().bindBidirectional(viewModel.fromCodeProperty());
        to.setItems(viewModel.getSupportedCodes());
        to.valueProperty().bindBidirectional(viewModel.toCodeProperty());
        resultText.textProperty().bind(viewModel.resultTextProperty());
    }
}
