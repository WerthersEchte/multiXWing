package de.fh_kiel.roboticlab.multixwing.game;

public enum Ship {
    XWing(3,2,3,2);

    private final int mAttack, mDefence, mHull, mShield;
    private final Movement mMovement[];

    Ship(int mAttack, int mDefence, int mHull, int mShield, Movement... mMovement) {
        this.mAttack = mAttack;
        this.mDefence = mDefence;
        this.mHull = mHull;
        this.mShield = mShield;
        this.mMovement = mMovement;
    }

    public int getAttack() {
        return mAttack;
    }

    public int getDefence() {
        return mDefence;
    }

    public int getHull() {
        return mHull;
    }

    public int getShield() {
        return mShield;
    }

    public Movement[] getMovement() {
        return mMovement;
    }
}
