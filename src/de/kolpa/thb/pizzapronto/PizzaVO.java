package de.kolpa.thb.pizzapronto;

import java.util.Arrays;

/**
 * Created by Kolpa on 25.04.2016 use at own risk might be horribly broken...
 * What is bigger than 11?                      4
 */
public class PizzaVO {
    private static int naechsteID;

    private final int ID;
    private String name;
    private float preis;
    private String[] zutaten;

    public PizzaVO() {
        this.ID = naechsteID;
        naechsteID++;
    }

    public PizzaVO(String name, float preis, String[] zutaten) {
        this();
        this.name = name;
        this.preis = preis;
        this.zutaten = zutaten;
    }

    public int getID() {
        return  this.ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public String[] getZutaten() {
        return zutaten;
    }

    public void setZutaten(String[] zutaten) {
        this.zutaten = zutaten;
    }

    private String getZutatenString() {
        String zutatenString = "";

        for (int i = 0; i < this.getZutaten().length - 1; i++) {
            zutatenString += this.getZutaten()[i] + ", ";
        }

        zutatenString = zutatenString.substring(0, zutatenString.length() - 2);

        zutatenString += " und " + this.getZutaten()[this.getZutaten().length - 1];

        return zutatenString;
    }

    public PizzaVO clone() {
        return new PizzaVO(this.getName(), this.getPreis(), Arrays.copyOf(this.getZutaten(), this.getZutaten().length));
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            PizzaVO pizza = (PizzaVO) other;
            return this.getID() == pizza.getID();
        }

        return false;
    }

    public String toString() {
        return "Pizza " + this.getName() + " mit: " + this.getZutatenString() + " für " + this.getPreis() + "€";
    }
}
