import java.util.*;
import java.text.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;


/*//////////BESKRIVELSE//////////*/
public class Arrangement {
	Kontaktperson kontakt;
	Billettregister reg;
	private static int aId = 1;
	private int pris;
	private boolean betalbar = true;
	private Date dato;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
	private String beskrivelse, navn;
	private BufferedImage bilde = null;
	private String bildeSti;
	
	
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
	/*Bilde sent med*/
	public Arrangement (String n, String b, String f, Kontaktperson k) {
		
		beskrivelse = b;
		navn = n;
		bildeSti = f;
	}

	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Kontaktperson(Kontaktperson k) {
		kontakt = k;
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
		if (dato==null)
			return "";
		String datoString = sdf.format(dato);
		return datoString;
	}
	public int get_Pris() {
		return pris;
	}
	public boolean get_Betalbar() {
		return betalbar;
	}
	public Kontaktperson get_Kontaktperson() {
		return kontakt;
	}
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = "";
		meld += "REFERANSE: " + get_aId() + "\r\n";
		String b = (get_Beskrivelse() != null) ? "Beskrivelse: " + get_Beskrivelse() : "Ingen beskrivelse";
		if (bildeSti != null)
			meld+="Arrangement har et bilde som vedlegg.";
		else
			meld+="Ikke noe bilde";
		meld += "Navn på arrangement: " + get_Navn() + "\r\n";
		if (get_Dato().equals(""))
			meld += "Dato " + get_Dato() + "\r\n"
				+ b + "\r\n";
		if(get_Betalbar() == true)
			meld += "Pris: " + get_Pris() + "kr \r\n";
		else
			meld += "Pris: Gratis \r\n";
		return meld;
	}
	
}
