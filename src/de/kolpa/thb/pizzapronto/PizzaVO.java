package de.kolpa.thb.pizzapronto;

import java.util.Arrays;

/**
 * Created by Kolpa on 25.04.2016 use at own risk might be horribly broken...
 * What is bigger than 11?                      4
 */
public class PizzaVO implements Cloneable {
    private String name;
    private float preis;
    private String[] zutaten;

    public PizzaVO() {
    }

    public PizzaVO(String name, String[] zutaten, float preis) {
        this.name = name;
        this.preis = preis;
        this.zutaten = zutaten;
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

        if (this.getZutaten().length == 1) {
            zutatenString = this.getZutaten()[0];
        } else {
            for (int i = 0; i < this.getZutaten().length - 1; i++) {
                zutatenString += this.getZutaten()[i] + ", ";
            }

            zutatenString = zutatenString.substring(0, zutatenString.length() - 2);

            zutatenString += " und " + this.getZutaten()[this.getZutaten().length - 1];
        }

        return zutatenString;
    }

    public PizzaVO clone() {
        try {
            return (PizzaVO) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int hashCode() {
        final int hashMultiplier = 31;
        int hc = 1;
        hc = hashMultiplier * hc + ((this.getName() == null) ? 0 : this.getName().hashCode());
        hc = hashMultiplier * hc + Float.floatToIntBits(this.getPreis());
        hc = hashMultiplier * hc + Arrays.hashCode(this.getZutaten());
        return hc;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other.getClass() == this.getClass()) {
            PizzaVO pizza = (PizzaVO) other;
            return this.hashCode() == pizza.hashCode();
        }

        return false;
    }

    public String toString() {
        return "Pizza " + this.getName() + " mit: " + this.getZutatenString() + " für " + this.getPreis() + "€";
    }
}
