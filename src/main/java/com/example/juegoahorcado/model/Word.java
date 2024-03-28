package com.example.juegoahorcado.model;

public class Word {

    private String word;

    private int length;

    private String outputLabel;

    public Word(String word){
        this.word = word;
        this.length = word.length();
    }

    public String getWord(){
        return this.word;
    }

    public int getLength() {
        return length;
    }

    public void setOutputLabel(String outputLabel){
        this.outputLabel += outputLabel;
    }


    public String getOutputLabel() {
        return outputLabel;
    }


}
