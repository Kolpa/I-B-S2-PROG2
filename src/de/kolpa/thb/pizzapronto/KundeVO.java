package de.kolpa.thb.pizzapronto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by Kolpa on 25.04.2016 use at own risk might be horribly broken...
 * Probably does some stuff right
 */
public class KundeVO {
    private static int naechsteID = 0;

    private final int ID;
    private String nachname;
    private String vorname;
    private String geschlecht;
    private LocalDate geburtsdatum;

    private Bestellung bestellung;

    public KundeVO() {
        this.ID = naechsteID;
        naechsteID++;
    }

    public KundeVO(String nachname, String vorname) {
        this();
        this.setNachname(nachname);
        this.setVorname(vorname);
    }

    public KundeVO(String nachname, String vorname, String geschlecht) {
        this(nachname, vorname);
        this.setGeschlecht(geschlecht);
    }

    public KundeVO(String nachname, String vorname, String geschlecht, LocalDate geburtsdatum) {
        this(nachname, vorname, geschlecht);
        this.setGeburtsdatum(geburtsdatum);
    }

    public KundeVO(String nachname, String vorname, String geschlecht, LocalDate geburtsdatum, Bestellung bestellung) {
        this(nachname, vorname, geschlecht, geburtsdatum);
        this.setBestellung(bestellung);
    }

    public int getID() {
        return this.ID;
    }
    
	public static int getNaechsteID() {
		return naechsteID;
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
    	if (this.getGeburtsdatum() == null)
    		return -1;
    	
    	short alter = (short) Period.between(this.getGeburtsdatum(), LocalDate.now()).getYears();
    	
    	if (alter < 18)
    		return -1;
    	else
    		return alter;
    	
    }

    private String getGeburtsdatumStr() {
        return this.getGeburtsdatum().format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }

    public boolean hasBestellung() {
        return this.getBestellung() != null;
    }

    public int hashCode() {
        final int hashMultiplier = 31;
        int hc = 1;
        hc = hashMultiplier * hc + this.berechneAlter();
        hc = hashMultiplier * hc + ((this.getGeburtsdatum() == null) ? 0 : this.getGeburtsdatum().hashCode());
        hc = hashMultiplier * hc + ((this.getGeschlecht() == null) ? 0 : this.getGeschlecht().hashCode());
        hc = hashMultiplier * hc + ((this.getNachname() == null) ? 0 : this.getNachname().hashCode());
        hc = hashMultiplier * hc + ((this.getVorname() == null) ? 0 : this.getVorname().hashCode());
        hc = hashMultiplier * hc + ((this.getBestellung() == null) ? 0 : this.getBestellung().hashCode());
        return hc;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            KundeVO kunde = (KundeVO) other;
            return this.getID() == kunde.getID();
        }

        return false;
    }

    public String toString() {
        return "Kunde " + this.getVorname() + " " + this.getNachname() + " ist " + this.getGeschlecht() + " und " + this.berechneAlter() + " Jahre alt geboren am " + this.getGeburtsdatumStr();
    }
}
