package com.example.juegoahorcado.model;

import javafx.scene.image.ImageView;

public class Image {
    public ImageView changeImage(int lifes){
        ImageView ahorcadoImage = new ImageView(new javafx.scene.image.Image(String.valueOf(getClass().getResource("/com/example/ahorcadogame/images/" + lifes + ".png"))));
        ahorcadoImage.setFitWidth(320);
        ahorcadoImage.setFitHeight(320);
        return ahorcadoImage;
    }
}
