// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// H�gskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen � s198524
// Roger Bl�tekj�r Johannessen � s186571
// Halvor R�nneseth � s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om personer					//
//	# Navn p� kontaktperson												//
//	# Epost til kontaktperson											//
//	# Telefonnummer til kontaktperson									//
//	# Metoder for � manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Person implements Serializable {
	private static final long serialVersionUID = -7313580225459341922L;
	private String fornavn;
	private String etternavn;
	private String epost;
	private String tlf;
	
	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	
	public Person (String f, String e, String m, String t) {
		fornavn = f;
		etternavn = e;
		epost = m;
		tlf = t;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public String get_Fornavn(){
		return fornavn;
	}
	
	public String get_Etternavn(){
		return etternavn;
	}
	
	public String get_Navn(){
		return fornavn + " " + etternavn;
	}
	
	public String get_Epost(){
		return epost;
	}
	
	public String get_Telefon(){
		return tlf;
	}
	
	//////////////////////
	
	public void set_Fornavn(String f){
		fornavn = f;
	}
	
	public void set_Etternavn(String e){
		etternavn = e;
	}
	
	public void set_Epost(String m){
		epost = m;
	}
	
	public void set_Telefon(String t){
		tlf = t;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	public String toString() {
		return fornavn + " " + etternavn + ", Epost: " + epost + ", Tlf: " + tlf + "\r\n";
	}
}//KLASSE PERSON SLUTT
