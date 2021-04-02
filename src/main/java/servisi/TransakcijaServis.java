package servisi;

import domen.Transakcija;

public class TransakcijaServis {
	
	
	public static void konvertuj(Transakcija t, double iznos, double valuta) {
		t.setKrajnjiIznos(iznos * valuta);
	}

}
