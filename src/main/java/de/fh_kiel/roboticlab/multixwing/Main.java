package de.fh_kiel.roboticlab.multixwing;

import de.fh_kiel.roboticlab.multixwing.javafx.MainMenu;
import de.fh_kiel.roboticlab.multixwing.javafx.StartGame;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.tuiofx.Configuration;
import org.tuiofx.TuioFX;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        TuioFX.enableJavaFXTouchProperties();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        final Pane root = new Pane();
        final Scene scene = new Scene(root, 1920, 1080);

        final Parent newGame = StartGame.get();

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if(me.getButton().equals(MouseButton.SECONDARY)) {
                //Circle circle = new Circle(me.getX(), me.getY(), 10, Color.BLUE);
                //root.getChildren().add(circle);
                try {
                    Parent vMainMenu = MainMenu.get();
                    root.getChildren().add(vMainMenu);

                    vMainMenu.setLayoutX(me.getX());
                    vMainMenu.setLayoutY(me.getY());
                }catch(IOException vIOException){
                    vIOException.printStackTrace();
                }
            }
        });


        TuioFX tuiofx = new TuioFX(primaryStage, Configuration.pqLabs());
        tuiofx.start();

        primaryStage.setTitle("multiXWing");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.show();

    }
}
