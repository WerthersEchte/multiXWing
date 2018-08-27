package de.fh_kiel.roboticlab.multixwing.game;

import java.util.ArrayList;
import java.util.List;

public enum Character {

    Wedge(Ship.XWing, Upgrade.Wedge);

    private final Ship mShip;
    private final Upgrade mUpgrade;
    private final List<UpgradeSlot> mSlots = new ArrayList<>();

    Character(Ship aShip, Upgrade aUpgrade, UpgradeSlot... aUpgradeSlots) {
        mShip = aShip;
        mUpgrade = aUpgrade;
        for(UpgradeSlot vSlot : aUpgradeSlots){
            mSlots.add(vSlot);
        }
    }

    public Ship getShip() {
        return mShip;
    }

    public Upgrade getUpgrade() {
        return mUpgrade;
    }

    public List<UpgradeSlot> getSlots() {
        return mSlots;
    }
}
