module com.example.currencye {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires rxjava;

    requires com.dlsc.formsfx;

    opens com.example.currencyConverter to javafx.fxml;
    exports com.example.currencyConverter;
    exports com.example.currencyConverter.view;
    opens com.example.currencyConverter.view to javafx.fxml;
    exports com.example.currencyConverter.modelView;
    opens com.example.currencyConverter.modelView to javafx.fxml;
}