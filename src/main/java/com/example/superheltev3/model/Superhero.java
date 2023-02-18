package com.example.superheltev3.model;

public class Superhero {
    public Superhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {
        this.name = name;
        this.superpower = superpower;
        this.human = human;
        this.introYear = introYear;
        this.strengthPoint = strengthPoint;
    }

    private String name;
    private String superpower;
    private boolean human;
    private int introYear;
    private double strengthPoint;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSuperpower() {
        return superpower;
    }
    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public boolean isHuman() {
        return human;
    }
    public void setHuman(boolean human) {
        this.human = human;
    }

    public int getIntroYear() {
        return introYear;
    }
    public void setIntroYear(int introYear) {
        this.introYear = introYear;
    }

    public double getStrengthPoint() {
        return strengthPoint;
    }
    public void setStrengthPoint(double strengthPoint) {
        this.strengthPoint = strengthPoint;
    }

    public String toString() {
        return ("Name: " + name + "\n" + "Superpower: " + superpower + "\n" + "Human: " + human
                + "\n" + "Introduction year: " + introYear + "\n" + "Strength points: " + strengthPoint + " \n ");
    }
}

