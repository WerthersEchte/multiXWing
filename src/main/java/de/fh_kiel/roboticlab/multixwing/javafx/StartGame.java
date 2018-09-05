package de.fh_kiel.roboticlab.multixwing.javafx;

import de.fh_kiel.roboticlab.multixwing.game.Match;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static de.fh_kiel.roboticlab.multixwing.Main.addChildToRootPane;
import static de.fh_kiel.roboticlab.multixwing.Main.getRootPane;
import static de.fh_kiel.roboticlab.multixwing.Main.removeChildFromRootPane;
import static de.fh_kiel.roboticlab.multixwing.javafx.Constants.PIXELPERCMX;
import static de.fh_kiel.roboticlab.multixwing.javafx.Constants.PIXELPERCMY;

public class StartGame{

    public Label ngSquadnumber;
    public VBox ngVBox;
    public TextField ngAreasizeX;
    public TextField ngAreasizeY;

    public static Parent get() throws IOException {
        return Helper.initControllerForTUIOFX(FXMLLoader.load(StartGame.class.getClassLoader().getResource("StartGame.fxml")));
    }

    public void decreaseSquadnumber(ActionEvent actionEvent) {
        int vSquadnumber = Integer.parseInt(ngSquadnumber.getText());

        if( vSquadnumber > 2 ){
            ngSquadnumber.setText(Integer.toString(vSquadnumber-1));
        }
    }

    public void increaseSquadnumber(ActionEvent actionEvent) {
        int vSquadnumber = Integer.parseInt(ngSquadnumber.getText());

        if( vSquadnumber < 4 ){
            ngSquadnumber.setText(Integer.toString(vSquadnumber+1));
        }
    }

    public void setAreasize90x90(ActionEvent actionEvent) {
        ngAreasizeX.setText(Integer.toString(90));
        ngAreasizeY.setText(Integer.toString(90));
    }

    public void setAreasize90x180(ActionEvent actionEvent) {
        ngAreasizeX.setText(Integer.toString(90));
        ngAreasizeY.setText(Integer.toString(180));
    }

    public void seAreasizeMax(ActionEvent actionEvent) {
        ngAreasizeX.setText(Integer.toString((int) (getRootPane().getWidth()/PIXELPERCMX)));
        ngAreasizeY.setText(Integer.toString((int) (getRootPane().getHeight()/PIXELPERCMY)));
    }

    public void startNewGame(ActionEvent actionEvent) {
        try {

            Match vNewMatch = new Match(
                    Integer.parseInt(ngAreasizeX.getText()),
                    Integer.parseInt(ngAreasizeY.getText()),
                    Integer.parseInt(ngSquadnumber.getText())
            );

            addChildToRootPane(Game.get(vNewMatch));
            close(actionEvent);
        } catch (IOException vException) {
            vException.printStackTrace();
        }
    }

    public void close(ActionEvent actionEvent) {
        ngVBox.setVisible(false);
        removeChildFromRootPane(ngVBox);
    }
}
