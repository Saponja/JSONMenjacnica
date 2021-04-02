package servisi;

import domen.Transakcija;

public class TransakcijaServis {
	
	
	public static void konvertuj(Transakcija t, double valuta) {
		t.setKrajnjiIznos(t.getPocetniIznos() * valuta);
	}

}
