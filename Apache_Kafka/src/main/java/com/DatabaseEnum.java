package com;

public enum DatabaseEnum {

    SQL(0, "SQL"), MYSQL(1, "MySql"), MONGODB(2, "MongoDB");

    private final int index;
    private final String name;

    private DatabaseEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
