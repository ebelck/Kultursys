////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om personer					//
//	# Navn på kontaktperson												//
//	# Epost til kontaktperson											//
//	# Telefonnummer til kontaktperson									//
//	# Metoder for å manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Person implements Serializable {
	
	private String fornavn;
	private String etternavn;
	private String epost;
	private String tlf;
	
	//////////////////
	//	KONSTRUKTØR	//
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
