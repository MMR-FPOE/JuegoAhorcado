package com.example.juegoahorcado.model;

import com.example.juegoahorcado.view.alert.AlertBox;
import javafx.scene.control.Alert;

public class Word {

    private String word;
    private int length;
    private int lifes = 6;
    private char[] wordArray;
    private char[] wordGameArray;
    private String wrongLetters = "Letras Erroneas: \n";
    private char[] wrongLettersArray = new char[6];
    private String outputLabel;
    private int clues = 0;

    public Word(String word){
        this.word = word;
        this.length = word.length();
        this.wordArray = word.toUpperCase().toCharArray();
        this.wordGameArray = new char[length];
        this.outputLabel = "_ ".repeat(length);
    }

    public Boolean checkWord(){
        for(char c: wordArray){
            if (!Character.isLetter(c)){
                return true;
            }
        }
        return false;
    }

    public String getWord(){
        return this.word;
    }

    public int getLength() {
        return length;
    }

    public boolean checkLetterInWord(char c){
        boolean booleanLetter = false;
        for(int i=0;i<this.length; i++){
            if(c == wordArray[i]){
                wordGameArray[i] = c;
                booleanLetter = true;
            }
        }
        return booleanLetter;
    }

    public String getOutputLabel() {
        outputLabel = "";
        for(char c: wordGameArray){
            if(Character.isLetter(c)){
                outputLabel += c + " ";
            } else{
                outputLabel += "_ ";
            }
        }
        return outputLabel;
    }

    public String outputWrongLetters(char letter){
        boolean repeatLetter = true;
        for(char c: wrongLettersArray){
            if(c == letter){
                repeatLetter = false;
            }
        }
        if(repeatLetter){
            wrongLetters += letter + " ";
            wrongLettersArray[6-lifes] = letter;
            lifes--;
        }
        return wrongLetters;
    }

    public void HelpClue() {

        int isReapetead = 0;

        if (clues < 3) {

            int randomIndex = (int) (Math.random() * length);

            for (char x : wordArray) {
                if (x == wordArray[randomIndex] && x != wordGameArray[randomIndex]) {
                    isReapetead++;
                }
            }
            if (isReapetead == 1) {
               // System.out.println(clues);
                clues++;
                wordGameArray[randomIndex] = wordArray[randomIndex];
                char clue = wordArray[randomIndex];
                checkLetterInWord(clue);

            } else {
                HelpClue();
            }
        } else{
            new AlertBox().showMessage("¡Agotaste las pistas!", "Pistas Agotadas", "Ya has utilizado las tres pistas disponibles :(");
        }
    }

    public int lifesCounter(){
        return lifes;
    }
}
