package de.fh_kiel.roboticlab.multixwing.game;

public enum Upgrade {
    Wedge(UpgradeSlot.Pilot);

    final UpgradeSlot mSlot[];

    Upgrade(UpgradeSlot... mSlot) {
        this.mSlot = mSlot;
    }
}
