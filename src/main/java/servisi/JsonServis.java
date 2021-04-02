package servisi;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domen.Transakcija;

public class JsonServis {
	
	
	
	public static void jsonUFajl(Transakcija t, String filename) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter file = new FileWriter(filename)){
			
			gson.toJson(t, file);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void jsonNizUFajl(Transakcija[] t, String filename) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter file = new FileWriter(filename)){
			
			gson.toJson(t, file);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
