package de.kolpa.thb.pizzapronto;

import java.awt.*;

/**
 * Created by Kolpa on 25.04.2016 use at own risk might be horribly broken...
 * Thar be dragons
 */
public class KochVO {
    private static int naechsteID = 0;

    private final int ID;
    private String nachname;
    private String vorname;
    private Color farbeSchuerze;

    public KochVO() {
        this.ID = naechsteID;
        naechsteID++;
    }

    public KochVO(String nachname, String vorname, Color farbeSchuerze) {
        this();
        this.setNachname(nachname);
        this.setVorname(vorname);
        this.setFarbeSchuerze(farbeSchuerze);
    }

    public int getID() {
        return  this.ID;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Color getFarbeSchuerze() {
        return farbeSchuerze;
    }

    public void setFarbeSchuerze(Color farbeSchuerze) {
        this.farbeSchuerze = farbeSchuerze;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            KochVO koch = (KochVO) other;
            return this.getID() == koch.getID();
        }

        return false;
    }

    public String toString() {
        return "Koch " + this.getVorname() + " " + this.getNachname() + " hat eine " + this.getFarbeSchuerze() + " Schürze";
    }
}
