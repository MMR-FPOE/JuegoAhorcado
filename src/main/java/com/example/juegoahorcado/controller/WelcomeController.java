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
    private TextField SecretWordTextField;
    @FXML
    private Label messageLabel;

    @FXML
    void onHandleCreateGame(ActionEvent event) throws IOException{
        String getWord = SecretWordTextField.getText();
        word = new Word(getWord);
        if (word.checkWord()){
            SecretWordTextField.setText("");
            messageLabel.setText("Ingrese una palabra correcta");
        } else if (word.getLength() < 5) {
            SecretWordTextField.setText("");
            messageLabel.setText("La palabra debe tener mínimo 5 letras");
        } else {
            GameController controller = GameStage.getInstance().getGameController();
            controller.gameStart(word);
            WelcomeStage.deleteInstance();
        }
    }

}
