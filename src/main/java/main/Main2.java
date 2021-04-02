package main;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.JsonObject;

import domen.Transakcija;
import servisi.ApiServis;
import servisi.JsonServis;
import servisi.TransakcijaServis;

public class Main2 {

	public static void main(String[] args) {
		
		Transakcija t = new Transakcija();
		t.setIzvornaValuta("USD");
		t.setPocetniIznos(54);
		Date datum = new Date();
		
		
		Transakcija[] transakcije = {new Transakcija("USD", 100, datum), new Transakcija("USD", 100, datum), new Transakcija("USD", 100, datum) };
		
		HttpURLConnection con = ApiServis.get(t, null);
		
		JsonObject res = ApiServis.responseToJson(con);
		
		double eur = res.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
		double chf = res.get("quotes").getAsJsonObject().get("USDCHF").getAsDouble();
		double cad = res.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble();
		
		TransakcijaServis.konvertuj(transakcije[0], eur);
		TransakcijaServis.konvertuj(transakcije[1], chf);
		TransakcijaServis.konvertuj(transakcije[2], cad);
		
		JsonServis.jsonNizUFajl(transakcije, "ostale_transakcije.json");

	}

}
