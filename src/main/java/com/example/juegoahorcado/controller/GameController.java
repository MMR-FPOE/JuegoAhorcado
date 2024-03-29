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

        int isReapetead = 0;

        gameWord.setText("_ ".repeat(word.getLength()));

        int randomIndex = (int) (Math.random() * word.getLength());

        for (char x: wordArray){
            if (x == wordArray[randomIndex] && x != guessedLetters[randomIndex]){
                isReapetead++;
            }
        }
        if (isReapetead == 1){
            String charBonus = String.valueOf(wordArray[randomIndex]);
            guessedLetters[randomIndex] = wordArray[randomIndex] ;
            word.setOutputLabel(charBonus);
        }else {
            wordHelp(event);
        }


    }

    @FXML

    public void wordGame(){

        String guessedLetter = letter.getText();

        for (char c : wordArray){
            if ( c == guessedLetter.charAt(0)){
                word.setOutputLabel(c + " ");
                guessedLetters[word.indexOf(c)] = c;
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
