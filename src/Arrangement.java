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
	BufferedImage bilde = null; {
		
		try {
		    bilde = ImageIO.read(new File("navn.*"));
		} catch (IOException e) {
			System.out.println("Finner ikke bilde ved angitt filbane");
		}
	}
	
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
	
	
	 /*//////////////////////////
	  KONTAKTPERSON MANIPULERING START
	 *//////////////////////////
	
	public boolean leggTilKontaktperson( Kontaktperson k){
		if(k == null)
			return false;
		
		if(førsteK == null){
			førsteK = k;
			return true;
		}
		
		Kontaktperson peker = førsteK;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = k;
		return true;
	}
	
	public boolean slettKontaktpersonViaEpost(String e){
		if(førsteK == null)
			return false;
		
		if(førsteK.get_Epost().equalsIgnoreCase(e)){
			førsteK = førsteK.neste;
			return true;
		}
		
		Kontaktperson peker = førsteK;
		while(peker.neste != null){
			if(peker.neste.get_Epost().equalsIgnoreCase(e)){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	public boolean slettKontaktpersonViaTlf(String t){
		if(førsteK == null)
			return false;
		
		if(førsteK.get_Tlf().equalsIgnoreCase(t)){
			førsteK = førsteK.neste;
			return true;
		}
		
		Kontaktperson peker = førsteK;
		while(peker.neste != null){
			if(peker.neste.get_Tlf().equalsIgnoreCase(t)){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	
	public Kontaktperson finnKontaktpersonViaEpost(String e){
		if(førsteK == null)
			return null;
		
		Kontaktperson peker = førsteK;
		while (peker != null){
			if(peker.get_Epost().equalsIgnoreCase(e))
				return peker;
			peker = peker.neste;
		}
		return null;
	}

	// Disse tre funksjonene blir kanskje utdaterte av en klasse høyere opp i hierarkiet.
	
	public Kontaktperson finnKontaktpersonViaTlf(String t){
		if(førsteK == null)
			return null;
		
		Kontaktperson peker = førsteK;
		while (peker != null){
			if(peker.get_Tlf().equalsIgnoreCase(t))
				return peker;
			peker = peker.neste;
		}
		return null;
	}
	
	public String listKontaktpersoner(){
		String svar = "Alle våre kontaktpersoner:\r\n";
		if(førsteK ==null)
			return svar += "* Ingen kontaktpersoner registrert på kulturhus"; 
		
		Kontaktperson peker = førsteK;
		while(peker != null){
			svar += "* " + peker.toString() + "\r\n";
			peker = peker.neste;
		}
		return svar;
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
		return navn + " skal holdes " + get_Dato() + ".\n";
	}
	
}
