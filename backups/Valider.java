// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// Høgskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen – s198524
// Roger Bløtekjær Johannessen – s186571
// Halvor Rønneseth – s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
//	Dette er en statisk klasse med metoder for å validere input			//
//////////////////////////////////////////////////////////////////////////

import java.io.*;

public final class Valider implements Serializable {

	private static final long serialVersionUID = -6113904719695422084L;

	//////////////////////
	//	KONSTRUKTØRER	//
	//////////////////////	
	
	private Valider(){
	}
	
	//////////////
	//	METODER	//
	//////////////

	//sjekker at navn kun består av store og små bokstaver samt " '-" 
	//Dette gir mulighet for navn som Per-Gunnar, Jan Einar og etternavn som D'Angelo
	public static boolean navn(String s){
		return s.matches("[a-zæøåA-ZÆØÅ]*[ -a-zæøåA-ZÆØÅ]*?");
		//return s.matches("[A-Z]'?[- a-zA-Z]( [a-zA-Z])");
	}
	
	//sjekker at epost er riktig formatert
	public static boolean epost(String s){
		//RegEx for epost er lånt fra Mkyong.com : http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
		return s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		//return s.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
	}
	
	//sjekker at telefonnr er riktig formatert
	public static boolean telefon(String s){
		return s.matches("[0-9]{8}");
	}
	
	//Sjekker om strengene for oppretting av et personobjekt er gyldige
	//returnerer en streng med feilmeldinger
	public static String person(String fornavn, String etternavn, String epost, String telefon){
		String retur ="";
		if(!navn(fornavn))
			retur += "Fornavn kan kun bestå av store og små bokstaver, mellomrom, ' eller -\r\n";
		if(!navn(etternavn))
			retur += "Etternavn kan kun bestå av store og små bokstaver, mellomrom, ' eller -\r\n";
		if(!epost(epost))
			retur += "Oppgi en gyldig epost-adresse\r\n";
		if(!telefon(telefon))
			retur += "Oppgi et gyldig telefonnr\r\n";
		return retur;
	}
	
	//sjekker at dato er i formatet DD-MM-ÅÅÅÅ TT:mm 
	public static boolean tittel(String s){
		return s.matches("[0-9A-Za-z\\s.,?!-\"]+");
	}
	
	//sjekker at beskrivelser er riktig formatert.
	//Godkjenner en eller flere ord som inneholder tall og bokstaver samt ., ?!-"
	public static boolean beskrivelse(String s){
		return s.matches("[0-9A-Za-z\\s.,?!-\"]+");
	}
	
	//sjekker at bildefil er riktig formatert
	public static boolean filnavn(String s){
		return s.matches("");
	}
	//sjekker at dato er i formatet DD-MM-ÅÅÅÅ TT:mm 
	public static boolean dato(String s){
		return s.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}");
	}
	
	//sjekker at pris er riktig formatert
	public static boolean pris(String s){
		return s.matches("[0-9]+");
	}
	
	//sjekker at antall er riktig formatert
	public static boolean antall(String s){
		return s.matches("[0-9]+");
	}
}//KLASSE VALIDER SLUTT
