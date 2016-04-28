package com;

public abstract class Charachter {

    private final Level level;

    private String ability;

    public Charachter(Level level) {
        this.level = level;
    }

    public void move() {
        System.out.println("Moving with Ability :" + ability + " in Level - " + level);
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
