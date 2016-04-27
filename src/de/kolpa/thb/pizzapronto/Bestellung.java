package de.kolpa.thb.pizzapronto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bestellung {
	private LocalDateTime zeitstempelBestellung;
	private LocalDateTime zeitstempelAuslieferung;
	
	public Bestellung() {
		this(null, null);
	}
	
	public Bestellung(LocalDateTime zeitstempelBestellung, LocalDateTime zeitstempelAuslieferung) {
		this.setZeitstempelBestellung(zeitstempelBestellung);
		this.setZeitstempelAuslieferung(zeitstempelAuslieferung);
	}
	
	public LocalDateTime getZeitstempelBestellung() {
		return zeitstempelBestellung;
	}
	
	public void setZeitstempelBestellung(LocalDateTime zeitstempelBestellung) {
		this.zeitstempelBestellung = zeitstempelBestellung;
	}
	
	public LocalDateTime getZeitstempelAuslieferung() {
		return zeitstempelAuslieferung;
	}
	
	public void setZeitstempelAuslieferung(LocalDateTime zeitstempelAuslieferung) {
		this.zeitstempelAuslieferung = zeitstempelAuslieferung;
	}
	
	private String formatZeitstempel(LocalDateTime zeitstempel) {
		return zeitstempel.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
    public int hashCode() {
        final int hashMultiplier = 31;
        int hc = 1;
        hc = hashMultiplier * hc + ((this.getZeitstempelBestellung() == null) ? 0 : this.getZeitstempelBestellung().hashCode());
        hc = hashMultiplier * hc + ((this.getZeitstempelAuslieferung() == null) ? 0 : this.getZeitstempelAuslieferung().hashCode());
        return hc;
    }
	
	public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            Bestellung bestellung = (Bestellung) other;
            return this.hashCode() == bestellung.hashCode();
        }

        return false;
	}
	
	public String toString() {
		return "Eine bestellung wurde um " + this.formatZeitstempel(this.getZeitstempelBestellung()) + " bestellt und um " + this.formatZeitstempel(this.getZeitstempelAuslieferung()) + " geliefert.";
	}

}
