module com.example.juegoahorcado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juegoahorcado to javafx.fxml;
    exports com.example.juegoahorcado;
}