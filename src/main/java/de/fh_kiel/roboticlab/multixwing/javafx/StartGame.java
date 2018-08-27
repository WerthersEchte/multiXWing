package de.fh_kiel.roboticlab.multixwing.javafx;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;

import java.io.IOException;

public class StartGame extends Parent{

    public static Parent get() throws IOException {
        return Helper.initControllerForTUIOFX(FXMLLoader.load(StartGame.class.getClassLoader().getResource("StartGame.fxml")));
    }


}
