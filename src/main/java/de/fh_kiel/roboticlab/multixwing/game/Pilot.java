package de.fh_kiel.roboticlab.multixwing.game;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Pilot {

    private int mId = -1;
    private final Character mPilot;

    private final List<Upgrade> mUpgrades = new ArrayList<>();

    private int mCurrentShield;
    private final List<Pair<Damage,Boolean>> mCurrentDemage = new ArrayList<>();

    public Pilot(Character mPilot) {
        this.mPilot = mPilot;
        mCurrentShield = mPilot.getShip().getShield();
    }
}
