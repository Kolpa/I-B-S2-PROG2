package de.kolpa.thb.pizzapronto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Bestellung {
	private LocalDateTime zeitstempelBestellung;
	private LocalDateTime zeitstempelAuslieferung;

	private int MAX_GERICHTE = 100;

	private PizzaVO[] warenkorb;
	private int index;

    private KundeVO kunde;
	
	public Bestellung() {
		this(null, null, null);
	}
	
	public Bestellung(LocalDateTime zeitstempelBestellung, LocalDateTime zeitstempelAuslieferung, KundeVO kunde) {
		this.setZeitstempelBestellung(zeitstempelBestellung);
		this.setZeitstempelAuslieferung(zeitstempelAuslieferung);

		this.warenkorb = new PizzaVO[this.getMAX_GERICHTE()];
		this.index = 0;

		this.kunde = kunde;
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

	public PizzaVO[] getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(PizzaVO[] warenkorb) {
		this.warenkorb = warenkorb;
	}

	private String getWarenkorbString() {
		String warenkorbString = "";

		for (int i = 0; i < this.index; i++) {
			if (this.getWarenkorb()[i] != null)
				warenkorbString += this.getWarenkorb()[i].toString() + "\n";
		}

		if (this.index != 0)
			warenkorbString = warenkorbString.substring(0, warenkorbString.length() - 2);

		return warenkorbString;
	}

	public int getIndex() {
		return index;
	}

	public int getMAX_GERICHTE() {
		return MAX_GERICHTE;
	}

    public KundeVO getKunde() {
        return kunde;
    }

    public void setKunde(KundeVO kunde) {
        this.kunde = kunde;
    }

	public void hinzufuegenGericht(PizzaVO gericht) {
		this.getWarenkorb()[this.getIndex()] = gericht;
		this.index++;
	}

	public void loescheLetztesGericht() {
		this.index--;
		this.getWarenkorb()[this.getIndex()] = null;
	}

	public PizzaVO getGericht(int index) {
		return this.getWarenkorb()[index];
	}

	public int getAnzGerichte() {
		return this.getIndex() + 1;
	}
	
    public int hashCode() {
        final int hashMultiplier = 31;
        int hc = 1;
        hc = hashMultiplier * hc + ((this.getZeitstempelBestellung() == null) ? 0 : this.getZeitstempelBestellung().hashCode());
        hc = hashMultiplier * hc + ((this.getZeitstempelAuslieferung() == null) ? 0 : this.getZeitstempelAuslieferung().hashCode());
		hc = hashMultiplier * hc + Arrays.hashCode(this.getWarenkorb());
		hc = hashMultiplier * hc + this.getIndex();
        hc = hashMultiplier * hc + ((this.getKunde() == null) ? 0 : this.getKunde().hashCode());
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
		return "Eine bestellung wurde von " + this.getKunde().toString() + " um " + this.formatZeitstempel(this.getZeitstempelBestellung()) + " bestellt und um " + this.formatZeitstempel(this.getZeitstempelAuslieferung()) + " geliefert, der Warenkorb enthält: " + this.getWarenkorbString();
	}

}
