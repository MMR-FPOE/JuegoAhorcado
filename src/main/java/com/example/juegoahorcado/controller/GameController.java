package com.example.juegoahorcado.controller;

import com.example.juegoahorcado.model.Image;
import com.example.juegoahorcado.model.Word;
import com.example.juegoahorcado.view.WelcomeStage;
import com.example.juegoahorcado.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GameController {

    private Word word;

    @FXML
    private Label gameWordLabel;
    @FXML
    private TextField letter;
    @FXML
    private VBox boxAhorcado;
    private ImageView ahorcadoImage;
    @FXML
    private Label wrongLetters;

    // gets the hint and displays it in the label
    @FXML
    public void wordHelp(ActionEvent event){
        word.HelpClue();
        gameWordLabel.setText(word.getOutputLabel());
        checkGameWin();
    }
    // Get the word object and assigns it to the current
    public void gameStart(Word inputWord){
        word = inputWord;
        gameWordLabel.setText(word.getOutputLabel());
        createImage(word.lifesCounter());
    }
    // Update the image
    private void createImage(int lifes){
        if(ahorcadoImage != null){
            boxAhorcado.getChildren().remove(ahorcadoImage);
        }
        Image image = new Image();
        ahorcadoImage = image.changeImage(lifes);
        boxAhorcado.getChildren().addAll(ahorcadoImage);
    }

    // verifies the letter, if is wrong or right, update the game
    public void checkLetterInWord(){
        String stringLetter = letter.getText();
        if(!stringLetter.isEmpty()){
            char guessedLetter = stringLetter.toUpperCase().charAt(0);
            boolean wrong = word.checkLetterInWord(guessedLetter);
            if (!wrong){
                boxAhorcado.getChildren().remove(ahorcadoImage);
                wrongLetters.setText(word.outputWrongLetters(guessedLetter));
                createImage(word.lifesCounter());
            }
            gameWordLabel.setText(word.getOutputLabel());
            letter.setText("");
            checkGameWin();
        }
    }

    // updates the label, check if the letter is valid, converts it to uppercase
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

    //check if the player win or lose, displays an alert

    private void checkGameWin(){
        if(word.winGame()){
            new AlertBox().WinOrLose("Ganaste", "El juego terminó", "¡Felicitades has completado la palabra secreta!");
        } else if (word.lifesCounter() == 0) {
            new AlertBox().WinOrLose("Perdiste", "El juego terminó", "Perdiste, la palabra era " + word.getWord());
        }
    }


}
