package com.kartik.constant;

public enum Sex {
    MALE("MALE"), FEMALE("FEMALE");
    String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "value='" + value + '\'' +
                '}';
    }
}
