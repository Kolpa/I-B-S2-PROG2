package de.kolpa.thb.pizzapronto;

import java.util.Arrays;

/**
 * Created by kolya on 25.04.2016.
 */
public class PizzaVO {
    private static int naechsteID;

    private int ID;
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

        for (int i = 0; i < this.zutaten.length - 1; i++) {
            zutatenString += this.zutaten[i] + ", ";
        }

        zutatenString = zutatenString.substring(0, zutatenString.length() - 2);

        zutatenString += " und " + this.zutaten[this.zutaten.length - 1];

        return zutatenString;
    }

    public PizzaVO clone() throws CloneNotSupportedException {
        PizzaVO clone = (PizzaVO) super.clone();
        clone.zutaten = Arrays.copyOf(this.zutaten, this.zutaten.length);
        return clone;
    }

    public boolean equals(Object other) {
        if (other.getClass() == this.getClass()) {
            PizzaVO pizza = (PizzaVO) other;
            return this.ID == pizza.ID;
        }
        return false;
    }

    public String toString() {
        return "Pizza " + this.name + " mit: " + getZutatenString() + " für " + preis + "€";
    }
}
