package com.example.juegoahorcado.controller;

import com.example.juegoahorcado.view.GameStage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.example.juegoahorcado.model.Word;
import com.example.juegoahorcado.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.io.IOException;

public class WelcomeController {
    private Word word;
    @FXML
    private TextField secretWordTextField;
    @FXML
    private Label messageLabel;

    @FXML
    void onHandleCreateGame(ActionEvent event) throws IOException{
        String getWord = secretWordTextField.getText();
        word = new Word(getWord);
        if (word.checkWord()){
            secretWordTextField.setText("");
            messageLabel.setText("Ingrese una palabra correcta");
        } else if (word.getLength() < 5) {
            secretWordTextField.setText("");
            messageLabel.setText("La palabra debe tener mínimo 5 letras");
        } else {
            GameController controller = GameStage.getInstance().getGameController();
            controller.gameStart(word);
            WelcomeStage.deleteInstance();
        }
    }

}
