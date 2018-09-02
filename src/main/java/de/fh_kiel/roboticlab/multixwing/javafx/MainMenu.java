package de.fh_kiel.roboticlab.multixwing.javafx;

import de.fh_kiel.roboticlab.multixwing.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static de.fh_kiel.roboticlab.multixwing.Main.addChildToRootPane;
import static de.fh_kiel.roboticlab.multixwing.Main.removeChildFromRootPane;
import static de.fh_kiel.roboticlab.multixwing.javafx.Helper.moveToMouseAndRotateToNearestBorder;

public class MainMenu implements Initializable {

    public VBox mmVBox;

    public static Parent get() throws IOException {
        return Helper.initControllerForTUIOFX(FXMLLoader.load(StartGame.class.getClassLoader().getResource("MainMenu.fxml")));
    }

    public void close(ActionEvent actionEvent) {
        mmVBox.setVisible(false);
        removeChildFromRootPane(mmVBox);
    }

    public void newGame(ActionEvent actionEvent) {
        try {
            Parent vNewGame = StartGame.get();
            addChildToRootPane(vNewGame);
            System.out.println(mmVBox.getTranslateX() + " " + mmVBox.getTranslateY());
            moveToMouseAndRotateToNearestBorder(vNewGame,mmVBox.getTranslateX(), mmVBox.getTranslateY());
            close(actionEvent);
        } catch (IOException vIOException) {
            vIOException.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
