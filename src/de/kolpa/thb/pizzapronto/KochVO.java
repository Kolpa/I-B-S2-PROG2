package de.kolpa.thb.pizzapronto;

import java.awt.*;

/**
 * Created by Kolpa on 25.04.2016 use at own risk might be horribly broken...
 * Thar be dragons
 */
public class KochVO {
    private String nachname;
    private String vorname;
    private Color farbeSchuerze;

    public KochVO() {
    	
    }

    public KochVO(String nachname, String vorname, Color farbeSchuerze) {
        this.setNachname(nachname);
        this.setVorname(vorname);
        this.setFarbeSchuerze(farbeSchuerze);
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
        if (farbeSchuerze == null)
            this.farbeSchuerze = Color.BLACK;
        else
            this.farbeSchuerze = farbeSchuerze;
    }

    public int hashCode() {
        final int hashMultiplier = 31;
        int result = 1;
        result = hashMultiplier * result + ((this.getFarbeSchuerze() == null) ? 0 : this.getFarbeSchuerze().hashCode());
        result = hashMultiplier * result + ((this.getNachname() == null) ? 0 : this.getNachname().hashCode());
        result = hashMultiplier * result + ((this.getVorname() == null) ? 0 : this.getVorname().hashCode());
        return result;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            KochVO koch = (KochVO) other;
            return this.hashCode() == koch.hashCode();
        }

        return false;
    }

    public String toString() {
        return "Koch " + this.getVorname() + " " + this.getNachname() + " hat eine " + this.getFarbeSchuerze() + " Schürze";
    }
}
