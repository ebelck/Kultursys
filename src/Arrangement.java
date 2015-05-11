////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om arrangementene:				//
//	# Referansenummer for arrangementet									//
//	# Neste referansenummer												//
//	# Navn/tittel på arrangementet										//
//	# Beskrivelse av arrangementet										//
//	# Bilde for arrangementet											//
//	# Dato for arrangementet											//
//	# Indikator for billettsalg											//
//	# Billettpris														//
//	# Kontaktperson for arrangementet									//
//	# Register over alle solgte billetter								//
//	# Metoder for å manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.text.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Arrangement {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
	
	private  int aId = 0;
	private static int nesteId = 1;
	private String navn, beskrivelse;
	private BufferedImage bilde = null;
	private String bildeSti;
	private Date dato;
	private boolean billettsalg = false;
	private int pris;
	Kontaktperson kontakt;
	Billettregister reg;
	
	//////////////////////
	//	KONSTRUKTØRER	//
	//////////////////////	
	
	public Arrangement (String n, Kontaktperson k) {
	//Minimumskrav = navn + Kontaktperson
		aId = nesteId++;
		navn = n;
		kontakt = k;
	}
	
	public Arrangement (String n, Kontaktperson k, String d) {
	//Minimumskarv + dato
	//Dato må være oppgitt i formatet dd-mm-ååå tt:mm
	//Kan dette løses med en RegEx-validering? str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no sånt jævlig.");
		}
		
		aId = nesteId++;
		navn = n;
		kontakt = k;
	}
	
	public Arrangement (String n, String b, Kontaktperson k, String d, int p, int a) {
	//Minimumskarv + dato + beskrivelse + pris og antall billetter	
	//Dato må være oppgitt i formatet dd-mm-ååå tt:mm
	//Kan dette løses med en RegEx-validering? str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")	/*String for dato skal være innsatt i følgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no sånt jævlig.");
		}
		aId = nesteId++;
		navn = n;
		beskrivelse = b;
		billettsalg = true;
		pris = p;
		kontakt = k;
		reg = new Billettregister(a);
	}
	
	//HER MÅ DET LAGES FLERE KONSTRUKTØRER HVIS VI SKAL DEKKE OPP FOR ALLE MULIGHETER
	/*Bilde sent med*/
	public Arrangement (String n, String b, String f, Kontaktperson k) {
		
		aId = nesteId++;
		navn = n;
		beskrivelse = b;
		bildeSti = f;
		kontakt = k;
	}

	//////////////////////////
	//	KONSTRUKTØRER SLUTT	//
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
	/*String for dato skal være innsatt i følgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no sånt jævlig.");
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
	
	//	Metoder som må lages:
	//	¤ Legge til flere billetter
	//	¤ Fjerne billetter
	//	¤ Bestille billetter
	//	¤ Avbestille billetter
	//	¤ Søke opp Billetter
	// 	¤ Flere?
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	public String toString(){
		String melding = "Referansenr:\t" + aId + "\r\n";
		melding += "Arrangement:\t" + navn + "\r\n";
		melding += (beskrivelse != null) ? "Beskrivelse:\t" + beskrivelse + "\r\n" : "Ingen beskrivelse" + "\r\n";
		melding += (bildeSti != null) ? "Bilde:\t" + bildeSti + "\r\n" : "Mangler bilde" + "\r\n";
		melding += (dato != null) ? "Dato:\t\t" + sdf.format(dato) + "\r\n" : "Dato ikke satt" + "\r\n";
		melding += (!billettsalg) ? "Pris:\t\tGratis\r\n" : "Pris:\t\tkr " + pris +".00\r\n";
		melding += (billettsalg) ? "Ledige bill.:\t" + (reg.antallBilletter() - reg.antallSolgteBilletter()) + "\r\n": "";
		melding += "Kontaktperson:\t" + kontakt + "\r\n";
		
		return melding;
	}
	
}//KLASSE ARRANGEMENT SLUTT
