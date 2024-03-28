package com.example.juegoahorcado.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    public GameStage() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/juegoahorcado/game-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setTitle("Juego Ahorcado");
        setResizable(false);
        setScene(scene);
        show();
    }
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE = new GameStage();
    }
    public static void deleteInstance(){
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }
    private static class GameStageHolder{
        private static GameStage INSTANCE;
    }
}