package de.fh_kiel.roboticlab.multixwing.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static de.fh_kiel.roboticlab.multixwing.Main.getRootPane;
import static de.fh_kiel.roboticlab.multixwing.Main.removeChildFromRootPane;
import static de.fh_kiel.roboticlab.multixwing.javafx.Constants.PIXELPERCMX;
import static de.fh_kiel.roboticlab.multixwing.javafx.Constants.PIXELPERCMY;

public class Options extends VBox {

    public VBox oVBox;
    public TextField oTFX;
    public TextField oTFY;

    public static Parent get() throws IOException {
        return Helper.initControllerForTUIOFX(new Options());
    }
    public Options() {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getClassLoader().getResource("Options.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        oTFX.setText( Double.toString(getRootPane().getWidth()/PIXELPERCMX));
        oTFY.setText( Double.toString(getRootPane().getHeight()/PIXELPERCMY));
    }

    public void close(ActionEvent actionEvent) {
        oVBox.setVisible(false);
        removeChildFromRootPane(oVBox);
    }

    public void saveValues(ActionEvent actionEvent) {

        try {
            PIXELPERCMX = getRootPane().getWidth() / Double.parseDouble(oTFX.getText());
            PIXELPERCMY = getRootPane().getHeight() / Double.parseDouble(oTFY.getText());

            close(actionEvent);
        }catch(Exception vException){
            vException.printStackTrace();
        }

    }
}
