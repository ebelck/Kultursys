import java.util.*;
import java.text.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Arrangement {
	Arrangement neste = null;
	Kontaktperson førsteK = null;
	private static int aId = 0;
	private int pris;
	private boolean betalbar = true;
	private Date dato;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
	private String beskrivelse, navn;
	public Boolean[] billettremse;;
	BufferedImage bilde = null;
	
	/*Minimumskravet for å opprette et arrangement*/
	public Arrangement (String n, Kontaktperson k) {
		
		navn = n;
		aId++;
	}
	/*Minimumskrav + dato er satt + pris ikke oppgitt*/
	public Arrangement (String n, Kontaktperson k, String d) {
		
		
		/*String for dato skal være innsatt i følgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no sånt jævlig.");
		}
		
		navn = n;
		betalbar = false;
	}
	/*All informasjon satt*/
	public Arrangement (String n, String b, Kontaktperson k, String d, int p) {
		
		
		/*String for dato skal være innsatt i følgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no sånt jævlig.");
		}
		beskrivelse = b;
		navn = n;
		pris = p;
	}

	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}
	/*String for dato skal være innsatt i følgende format: "31-08-1982 10:20";*/
	public void set_Dato(String d) {
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no sånt jævlig.");
		}
	}
	public String get_Navn() {
		return navn;
	}
	public int get_aId() {
		return aId;
	}
	public String get_Beskrivelse() {
		return beskrivelse;
	}
	public String get_Dato() {
		String datoString = sdf.format(dato);
		return datoString;
	}
	public int get_Pris() {
		return pris;
	}
	public boolean get_Betalbar() {
		return betalbar;
	}
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		return get_Navn() + " skal holdes " + get_Dato() + ".\n";
	}
	
}
