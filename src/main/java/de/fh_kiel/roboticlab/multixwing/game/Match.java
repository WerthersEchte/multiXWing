package de.fh_kiel.roboticlab.multixwing.game;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private List<Squad> mSquads = new ArrayList<>();

    private int mTurns = 0;

    private Phase mCurrentPhase = Phase.Setup;

}
