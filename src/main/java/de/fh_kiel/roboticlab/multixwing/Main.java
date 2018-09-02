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

import static de.fh_kiel.roboticlab.multixwing.javafx.Helper.moveToMouseAndRotateToNearestBorder;

public class Main extends Application {

    public static void main(String[] args) {
        TuioFX.enableJavaFXTouchProperties();
        launch(args);
    }

    private static final Pane mRoot = new Pane();
    public static Pane getRootPane(){
        return mRoot;
    }

    public static void addChildToRootPane(Node aNode){
        mRoot.getChildren().add(aNode);
    }

    public static void removeChildFromRootPane(Node aNode){
        mRoot.getChildren().remove(aNode);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        final Scene scene = new Scene(getRootPane(), 800, 600);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent aMouseEvent) -> {
            if(aMouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                //Circle circle = new Circle(me.getX(), me.getY(), 10, Color.BLUE);
                //root.getChildren().add(circle);
                try {
                    Parent vMainMenu = MainMenu.get();
                    addChildToRootPane(vMainMenu);
                    moveToMouseAndRotateToNearestBorder(vMainMenu,aMouseEvent.getX(), aMouseEvent.getY());
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
