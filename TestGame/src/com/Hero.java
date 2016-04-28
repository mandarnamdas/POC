package com;

public class Hero extends Charachter {

    public Hero(Level level) {
        super(level);
        if (level.equals(Level.Level1)) {
            this.setAbility("Run");
        } else if (level.equals(Level.Level2)) {
            this.setAbility("Move with bike");
        } else if (level.equals(Level.Level3)) {
            this.setAbility("Move with Car");
        }
    }
}
