package com;

public class Alien extends Charachter {

    public Alien(Level level) {
        super(level);
        if (level.equals(Level.Level1)) {
            this.setAbility("Fly");
        } else if (level.equals(Level.Level2)) {
            this.setAbility("swim");
        } else if (level.equals(Level.Level3)) {
            this.setAbility("swim fast");
        }
    }

}
