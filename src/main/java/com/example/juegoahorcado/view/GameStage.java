package com.example.juegoahorcado.view;

import com.example.juegoahorcado.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    private GameController gameController;
    public GameStage() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/juegoahorcado/game-view.fxml"));
        Parent root = loader.load();
        gameController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Juego Ahorcado");
        setResizable(false);
        setScene(scene);
        show();
    }
    public GameController getGameController(){
        return gameController;
    }
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE = new GameStage();
    }
    private static class GameStageHolder{
        private static GameStage INSTANCE;
    }
}