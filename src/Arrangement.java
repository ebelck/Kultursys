////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om arrangementene:				//
//	# Referansenummer for arrangementet									//
//	# Navn/tittel p� arrangementet										//
//	# Beskrivelse av arrangementet										//
//	# Bilde for arrangementet											//
//	# Dato for arrangementet											//
//	# Kontaktperson for arrangementet									//
//	# Indikator for billettsalg											//
//	# Billettpris														//
//	# Register over alle solgte billetter								//
//	# Metoder for � manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.text.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Arrangement {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
	
	private static int aId = 1;		//DETTE KAN BLI ET PROBLEM N�R VI SKAL GJENNOPPRETTE FRA FIL
	private String navn, beskrivelse;
	private BufferedImage bilde = null;
	private String bildeSti;
	private Date dato;
	Kontaktperson kontakt;
	private boolean billettsalg = false;
	private int pris;
	Billettregister reg;
	
	//////////////////////
	//	KONSTRUKT�RER	//
	//////////////////////	
	
	public Arrangement (String n, Kontaktperson k) {
	//Minimumskrav = navn + Kontaktperson
		navn = n;
		aId++;
	}
	
	public Arrangement (String n, Kontaktperson k, String d) {
	//Minimumskarv + dato
	//Dato m� v�re oppgitt i formatet dd-mm-��� tt:mm
	//Kan dette l�ses med en RegEx-validering? str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no s�nt j�vlig.");
		}
		
		navn = n;
	}
	
	public Arrangement (String n, String b, Kontaktperson k, String d, int p, int a) {
	//Minimumskarv + dato + beskrivelse + pris og antall billetter	
	//Dato m� v�re oppgitt i formatet dd-mm-��� tt:mm
	//Kan dette l�ses med en RegEx-validering? str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")	/*String for dato skal v�re innsatt i f�lgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no s�nt j�vlig.");
		}
		beskrivelse = b;
		navn = n;
		billettsalg = true;
		pris = p;
		reg = new Billettregister(a);
	}
	
	//HER M� DET LAGES FLERE KONSTRUKT�RER HVIS VI SKAL DEKKE OPP FOR ALLE MULIGHETER
	/*Bilde sent med*/
	public Arrangement (String n, String b, String f, Kontaktperson k) {
		
		beskrivelse = b;
		navn = n;
		bildeSti = f;
	}

	//////////////////////////
	//	KONSTRUKT�RER SLUTT	//
	//////////////////////////
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public void set_Navn(String n) {
		navn = n;
	}
	
	public void set_Kontaktperson(Kontaktperson k) {
		kontakt = k;
	}
	
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}
	
	public void set_Dato(String d) {
	/*String for dato skal v�re innsatt i f�lgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no s�nt j�vlig.");
		}
	}

	
	//////////////////////
	
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
	
	public boolean get_Billettsalg() {
		return billettsalg;
	}
	
	public Billettregister get_reg(){
		return reg;
	}
	
	public Kontaktperson get_Kontaktperson() {
		return kontakt;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	//	Metoder som m� lages:
	//	� Legge til flere billetter
	//	� Fjerne billetter
	//	� Bestille billetter
	//	� Avbestille billetter
	//	� S�ke opp Billetter
	// 	� Flere?
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	//!!!!!DENNE M� RYDDES I !!!!!
	
	public String toString() {
		String meld = "";
		meld += "REFERANSENUMMER:\t" + get_aId() + "\r\n";
		//Funker fram til hit
		
		String b = (get_Beskrivelse() != null) ? "Beskrivelse:\t" + get_Beskrivelse() : "Ingen beskrivelse";
		if (bildeSti != null)
			meld+="Arrangement har et bilde som vedlegg.\r\n";
		else
			meld+="Ikke noe bilde\r\n";
		meld += "Navn p� arrangement:\t" + get_Navn() + "\r\n";
		if (get_Dato().equals(""))
			meld += "Dato:\t" + get_Dato() + "\r\n"
				+ b + "\r\n";
		//Funker herfra
		if(get_Billettsalg() == true){
			meld += "Pris:\t" + get_Pris() + " kr\r\n";
			meld += "Ledige billetter:\t" + reg.get_antallLedigeBilletter();
		}
		else
			meld += "Pris:\tGratis \r\n";
		
		return meld;
	}
	
}
