package de.kolpa.thb.pizzapronto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by kolya on 25.04.2016.
 */
public class KundeVO {
    private static int naechsteID = 0;

    private int ID;
    private String nachname;
    private String vorname;
    private String geschlecht;
    private LocalDate geburtsdatum;

    public KundeVO() {
        this.ID = naechsteID;
        ID++;
    }

    public KundeVO(String nachname, String vorname) {
        this();
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public KundeVO(String nachname, String vorname, String geschlecht) {
        this(nachname, vorname);
        this.geschlecht = geschlecht;
    }

    public KundeVO(String nachname, String vorname, String geschlecht, LocalDate geburtsdatum) {
        this(nachname, vorname, geschlecht);
        setGeburtsdatum(geburtsdatum);
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

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
        if (berechneAlter() < 17)
            this.geburtsdatum = null;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public short berechneAlter() {
        return (short)Period.between(this.geburtsdatum, LocalDate.now()).getYears();
    }

    private String getGeburtsdatumStr() {
        return geburtsdatum.format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
    }

    public boolean equals(Object other) {
        if (other.getClass() == this.getClass()) {
            KundeVO kunde = (KundeVO) other;
            return this.ID == kunde.ID;
        }
        return false;
    }

    public String toString() {
        return "Kunde " + this.vorname + " " + this.nachname + " ist " + this.geschlecht + " und geboren am " + getGeburtsdatumStr();
    }
}
