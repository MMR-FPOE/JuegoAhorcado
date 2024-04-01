package com.example.juegoahorcado.controller;

import com.example.juegoahorcado.model.Image;
import com.example.juegoahorcado.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GameController {

    private Word word;

    @FXML
    private TextField fullWord;
    @FXML
    private Label gameWordLabel;
    @FXML
    private TextField letter;
    @FXML
    private VBox boxAhorcado;
    private ImageView ahorcadoImage;
    @FXML
    private Label wrongLetters;

    @FXML
    public void wordHelp(ActionEvent event){
        word.HelpClue();
        gameWordLabel.setText(word.getOutputLabel());

    }
    public void gameStart(Word inputWord){
        word = inputWord;
        gameWordLabel.setText(word.getOutputLabel());
        createImage();
    }
    private void createImage(){
        Image image = new Image();
        ahorcadoImage = image.changeImage(word.lifesCounter());
        boxAhorcado.getChildren().addAll(ahorcadoImage);
    }
    public void checkLetterInWord(){
        String stringLetter = letter.getText();
        if(!stringLetter.isEmpty()){
            char guessedLetter = stringLetter.toUpperCase().charAt(0);
            boolean wrong = word.checkLetterInWord(guessedLetter);
            if (!wrong){
                boxAhorcado.getChildren().remove(ahorcadoImage);
                wrongLetters.setText(word.outputWrongLetters(guessedLetter));
                createImage();
            }
            gameWordLabel.setText(word.getOutputLabel());
            letter.setText("");
        }
    }

    @FXML
    public void updateLetter(){
        String uniqueString = letter.getText();
        if(uniqueString.isEmpty() || !Character.isLetter(uniqueString.charAt(0))){
            letter.setText("");
        }else{
            char uniqueLetter = uniqueString.toUpperCase().charAt(0);
            letter.setText(Character.toString(uniqueLetter));
        }
    }

}
