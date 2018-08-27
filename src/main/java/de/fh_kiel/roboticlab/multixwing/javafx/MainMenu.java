package de.fh_kiel.roboticlab.multixwing.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    public VBox mmVBox;

    public static Parent get() throws IOException {
        return Helper.initControllerForTUIOFX(FXMLLoader.load(StartGame.class.getClassLoader().getResource("MainMenu.fxml")));
    }

    public void close(ActionEvent actionEvent) {
        mmVBox.setVisible(false);
        if (mmVBox.getParent() instanceof Pane) {
            ((Pane) mmVBox.getParent()).getChildren().remove(mmVBox);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
