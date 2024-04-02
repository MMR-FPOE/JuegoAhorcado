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
        this.word = word.toUpperCase();
        this.length = word.length();
        this.wordArray = word.toUpperCase().toCharArray();
        this.wordGameArray = new char[length];
        this.outputLabel = "_ ".repeat(length);
    }

    // check if the word entered contains only letters, returns a boolean value
    public Boolean checkWord(){
        for(char c: wordArray){
            if (!Character.isLetter(c)){
                return true;
            }
        }
        return false;
    }

    // return the word entered
    public String getWord(){
        return this.word;
    }

    // return the length of the word
    public int getLength() {
        return length;
    }

    // check if  the letter is in the word, if it is, stores it in the gameArray in the same position
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

    // return the String used for the game label,
    // Scrolls through the game array to store the letters in the string and if it is a letter it saves it, otherwise it saves an underscore.
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

    // Creates the string for the wrong letters, if the letter is not already in the wrongletters array
    public String outputWrongLetters(char letter){
        boolean repeatLetter = true;
        for(char c: wrongLettersArray){
            if(c == letter){
                repeatLetter = false;
            }
        }
        if(repeatLetter){
            wrongLetters += letter + " ";
            // save the letter in the position according to the lives
            wrongLettersArray[6-lifes] = letter;
            lifes--;
        }
        return wrongLetters;
    }

    // Provide a letter as a hint, the letter must appear only once in the word
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

    // return the number of lives
    public int lifesCounter(){
        return lifes;
    }


    public boolean winGame(){

        for(char c: wordGameArray){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
