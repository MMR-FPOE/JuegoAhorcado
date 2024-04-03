package com.example.juegoahorcado.view.alert;

import com.example.juegoahorcado.view.GameStage;
import com.example.juegoahorcado.view.WelcomeStage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class AlertBox implements IAlertBox {

    @Override

    public void showMessage(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();

    }

    public void WinOrLose(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        ButtonType restart = new ButtonType("Jugar de nuevo");
        ButtonType exit = new ButtonType("Salir");

        alert.getButtonTypes().setAll(restart, exit);

        ButtonType response = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (response == restart) {
            try {
                WelcomeStage.getInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            GameStage.deleteInstance();

        } else if (response == exit) {
            GameStage.deleteInstance();
        }


    }

}
