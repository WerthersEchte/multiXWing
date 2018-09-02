package de.fh_kiel.roboticlab.multixwing.javafx;

import de.fh_kiel.roboticlab.multixwing.game.Match;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game extends AnchorPane {

    public static Parent get(Match aMatch) throws IOException {
        Game vGame = new Game(aMatch);
        return vGame;
    }

    public Game(Match aMatch) {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getClassLoader().getResource("Game.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setMatch(aMatch);
    }

    public AnchorPane gPane;

    private Match mMatch;

    private void setMatch(Match aMatch) {
        mMatch = aMatch;

        gPane.setMaxWidth(mMatch.getAreasizeX());
        gPane.setMinWidth(mMatch.getAreasizeX());

        gPane.setMaxHeight(mMatch.getAreasizeY());
        gPane.setMinHeight(mMatch.getAreasizeY());
    }
}
