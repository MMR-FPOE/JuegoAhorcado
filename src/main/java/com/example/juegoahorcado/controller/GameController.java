package com.example.juegoahorcado.controller;

import com.example.juegoahorcado.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {

    private Word word = new Word("AHORCADO");

    private char[] wordArray = word.getWord().toCharArray();

    private char[] guessedLetters = new char[word.getLength()];

    @FXML

    private Label gameWord;

    @FXML
    private TextField letter;

    @FXML

    public void wordHelp(ActionEvent event){

        gameWord.setText("_ ".repeat(word.getLength()));
        int randomIndex = (int) (Math.random() * word.getLength());

    }

    @FXML

    public void wordGame(){
        int cont = 0;
        String guessedLetter = letter.getText();
       // String outputLabel = "";
        for (char c : wordArray){
            if ( c == guessedLetter.charAt(0)){
                cont++;
                word.setOutputLabel(c + " ");
                guessedLetters[cont] = c;
            }else{
                word.setOutputLabel("_ ");
            }
        }
        gameWord.setText(word.getOutputLabel());

    }

    public void wordVictory(){
        if (wordArray.length == word.getLength()){
            System.out.println("victory");
        }
    }

    public void onHandleButtonHelp(){

    }





}
