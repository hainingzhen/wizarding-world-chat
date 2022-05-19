package com.wizard.chat.models;

public enum Houses {
    GRYFFINDOR("Gryffindor"),
    RAVENCLAW("Ravenclaw"),
    HUFFLEPUFF("Hufflepuff"),
    SLYTHERIN("Slytherin");

    private final String houseName;

    Houses(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseName() {
        return houseName;
    }
}
