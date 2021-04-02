package main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import domen.Transakcija;
import servisi.ApiServis;
import servisi.JsonServis;
import servisi.TransakcijaServis;

public class Main1 {

	public static void main(String[] args) {
		
		Transakcija t = new Transakcija();
		t.setIzvornaValuta("USD");
		t.setPocetniIznos(54);
		t.setKrajnjaValuta("CAD");
		t.setDatumTransakcije(new Date());

		HttpURLConnection con = ApiServis.get(t);
		
		JsonObject res = ApiServis.responseToJson(con);
		
		double cad = res.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble();
		
		TransakcijaServis.konvertuj(t, t.getPocetniIznos(), cad);
		
		JsonServis.jsonUFajl(t);
			
			
			
		

	}

}
