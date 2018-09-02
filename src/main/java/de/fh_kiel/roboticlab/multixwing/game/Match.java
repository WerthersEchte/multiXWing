package de.fh_kiel.roboticlab.multixwing.game;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private final int mSquadnumber;
    private List<Squad> mSquads = new ArrayList<>();

    private int mTurns = 0;

    private Phase mCurrentPhase = Phase.Setup;

    private final int mAreasizeX;
    private final int mAreasizeY;

    public Match(int aAreasizeX, int aAreasizeY, int aSquadnumber) {
        mSquadnumber = aSquadnumber;
        mAreasizeX = aAreasizeX;
        mAreasizeY = aAreasizeY;
    }

    public double getAreasizeX() {
        return mAreasizeX;
    }

    public double getAreasizeY() {
        return mAreasizeY;
    }
}
