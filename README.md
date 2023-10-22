# Currency-Converter
The Currency Converter Application is a user-friendly tool that lets you convert currencies using real-time exchange rates.

The Currency Converter Application is structured as follows:

Model: The application's core logic resides in the ExchangeModel class. It handles data retrieval from the exchange rate API and conversion calculations.

View: The graphical user interface (GUI) is implemented using JavaFX in the ExchangeView class. It presents a user-friendly interface for input and output.

ViewModel: The ExchangeViewModel class acts as a bridge between the model and view. It manages user interactions and communicates with the model to perform currency conversions.

Utils: The application uses a configuration file (app.properties) to specify the API URL. This allows for easy customization and use of different exchange rate APIs. 
The Utils class is a crucial component of the Currency Converter Application. It provides a set of utility methods for making HTTP requests to fetch currency exchange rate data from a remote API in JSON format. 

FXML Layout: The FXML layout you provided is an integral part of the Currency Converter Application's graphical user interface (GUI). It defines the structure and appearance of the application's main window, making it user-friendly and visually appealing.
